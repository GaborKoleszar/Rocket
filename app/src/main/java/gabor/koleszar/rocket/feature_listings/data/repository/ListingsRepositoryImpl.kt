package gabor.koleszar.rocket.feature_listings.data.repository

import gabor.koleszar.rocket.common.Resource
import gabor.koleszar.rocket.feature_listings.data.local_datasource.RedditDataBase
import gabor.koleszar.rocket.feature_listings.data.remote_datasource.RedditApi
import gabor.koleszar.rocket.feature_listings.data.remote_datasource.RedditApi.Companion.BEST_LISTING_URL
import gabor.koleszar.rocket.feature_listings.data.remote_datasource.RedditApi.Companion.HOT_LISTING_URL
import gabor.koleszar.rocket.feature_listings.data.remote_datasource.RedditApi.Companion.NEW_LISTING_URL
import gabor.koleszar.rocket.feature_listings.data.remote_datasource.RedditApi.Companion.TOP_LISTING_URL
import gabor.koleszar.rocket.feature_listings.data.remote_datasource.dtos.ListingDto
import gabor.koleszar.rocket.feature_listings.domain.model.Listing
import gabor.koleszar.rocket.feature_listings.domain.repository.ListingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.text.SimpleDateFormat
import javax.inject.Inject
import javax.inject.Singleton

const val CACHE_EXPIRATION_MILLISECOND = 1200000

@Singleton
class ListingsRepositoryImpl @Inject constructor(
    private val redditApi: RedditApi,
    private val redditDb: RedditDataBase,
    private val simpleDateFormat: SimpleDateFormat
) : ListingsRepository {
    override suspend fun getListings(
        limit: Int,
        after: String?,
        listingUrl: String
    ): Flow<Resource<List<Listing>>> = flow {
        emit(Resource.Loading())

        val cacheResponse = getCachedResponse(listingUrl)
        if (cacheResponse != null) {
            emit(Resource.Success(cacheResponse))
        } else {
            try {
                val remoteResponse = getRemoteResponse(limit, after, listingUrl)
                redditDb.redditDao.clearListings()
                redditDb.redditDao.insertListings(remoteResponse.map { it.toListingEntity(listingUrl) })
                emit(Resource.Success(getCachedResponse(listingUrl)))
            } catch (e: HttpException) {
                emit(Resource.Error(message = "HttpException happened"))
            } catch (e: IOException) {
                emit(Resource.Error(message = "IOException happened"))
            } catch (e: Exception) {
                emit(Resource.Error(message = "Fatal error ${e.localizedMessage}"))
            }
        }
    }

    private suspend fun getCachedResponse(listingUrl: String): List<Listing>? {
        val cachedResponse =
            redditDb.redditDao.getListings(listingUrl).map { it.toListing(simpleDateFormat) }
        if (cachedResponse.isNotEmpty() && System.currentTimeMillis() - cachedResponse[0].timestampInserted < CACHE_EXPIRATION_MILLISECOND)
            return cachedResponse
        else
            return null
    }

    private suspend fun getRemoteResponse(
        limit: Int,
        after: String?,
        listingUrl: String
    ): List<ListingDto> {
        when (listingUrl) {
            BEST_LISTING_URL -> return redditApi.getBestListing(
                limit,
                after
            ).data.children.map { it.data }
            TOP_LISTING_URL -> return redditApi.getTopListing(
                limit,
                after
            ).data.children.map { it.data }
            NEW_LISTING_URL -> return redditApi.getNewListing(
                limit,
                after
            ).data.children.map { it.data }
            HOT_LISTING_URL -> return redditApi.getHotListing(
                limit,
                after
            ).data.children.map { it.data }
            //DEFAULT CASE
            else -> return redditApi.getBestListing(
                limit,
                after
            ).data.children.map { it.data }
        }
    }
}