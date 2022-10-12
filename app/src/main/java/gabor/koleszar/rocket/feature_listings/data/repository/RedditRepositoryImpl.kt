package gabor.koleszar.rocket.feature_listings.data.repository

import gabor.koleszar.rocket.common.Resource
import gabor.koleszar.rocket.feature_listings.data.local_datasource.RedditDataBase
import gabor.koleszar.rocket.feature_listings.data.remote_datasource.RedditApi
import gabor.koleszar.rocket.feature_listings.data.remote_datasource.dtos.ListingDto
import gabor.koleszar.rocket.feature_listings.domain.model.Listing
import gabor.koleszar.rocket.feature_listings.domain.repository.RedditRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.text.SimpleDateFormat
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RedditRepositoryImpl @Inject constructor(
    private val redditApi: RedditApi,
    private val redditDb: RedditDataBase,
    private val simpleDateFormat: SimpleDateFormat
) : RedditRepository {
    override suspend fun getListings(
        limit: Int,
        after: String?
    ): Flow<Resource<List<Listing>>> = flow {
        emit(Resource.Loading())

        val cacheResponse = getCachedResponse()
        if (cacheResponse.isNotEmpty() && cacheIsFresh(cacheResponse[0].timestampInserted)) {
            emit(Resource.Success(cacheResponse))
        } else {
            try {
                val remoteResponse = getRemoteResponse(limit, after)
                redditDb.redditDao.clearListings()
                redditDb.redditDao.insertListings(remoteResponse.map { it.toListingEntity() })
                emit(Resource.Success(getCachedResponse()))
            } catch (e: HttpException) {
                emit(Resource.Error(message = "HttpException happened"))
            } catch (e: IOException) {
                emit(Resource.Error(message = "IOException happened"))
            } catch (e: Exception) {
                emit(Resource.Error(message = "Fatal error ${e.localizedMessage}"))
            }
        }
    }

    private fun cacheIsFresh(timestamp: Long): Boolean {
        return System.currentTimeMillis() - timestamp < 1200000
    }

    private suspend fun getCachedResponse(): List<Listing> {
        return redditDb.redditDao.getListings().map { it.toListing(simpleDateFormat) }
    }

    private suspend fun getRemoteResponse(limit: Int, after: String?): List<ListingDto> {
        return redditApi.getBestListing(limit, after).data.children.map { it.data }
    }
}