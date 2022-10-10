package gabor.koleszar.rocket.feature_listings.data.repository

import gabor.koleszar.rocket.common.Resource
import gabor.koleszar.rocket.feature_listings.data.local_datasource.RedditDataBase
import gabor.koleszar.rocket.feature_listings.data.remote_datasource.RedditApi
import gabor.koleszar.rocket.feature_listings.domain.model.Listing
import gabor.koleszar.rocket.feature_listings.domain.repository.RedditRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RedditRepositoryImpl @Inject constructor(
    private val redditApi: RedditApi,
    private val redditDb: RedditDataBase
) : RedditRepository {
    override suspend fun getListings(
        limit: Int,
        after: String?
    ): Flow<Resource<List<Listing>>> = flow {
        emit(Resource.Loading())

        try {
            val response = redditApi.getBestListing(limit, after).data.children
            val parsedResponse = response.map { it.data.toListing() }
            emit(Resource.Success(parsedResponse))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "HttpException happened"))
        } catch (e: IOException) {
            emit(Resource.Error(message = "IOException happened"))
        } catch (e: Exception) {
            emit(Resource.Error(message = "Fatal error ${e.localizedMessage}"))
        }
    }
}