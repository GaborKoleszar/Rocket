package gabor.koleszar.rocket.feature_listings.data.repository

import gabor.koleszar.rocket.common.Resource
import gabor.koleszar.rocket.feature_listings.data.local_datasource.ListingsLocalDataSource
import gabor.koleszar.rocket.feature_listings.data.remote_datasource.ListingsRemoteDataSource
import gabor.koleszar.rocket.feature_listings.domain.model.Listing
import gabor.koleszar.rocket.feature_listings.domain.repository.ListingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ListingsRepositoryImpl @Inject constructor(
    private val remoteDataSource: ListingsRemoteDataSource,
    private val localDataSource: ListingsLocalDataSource
) : ListingsRepository {
    override suspend fun getListings(
        limit: Int,
        after: String?,
        listingUrl: String
    ): Flow<Resource<List<Listing>>> = flow {
        emit(Resource.Loading())

        val cacheResponse = localDataSource.getListings(listingUrl)
        if (cacheResponse != null) {
            emit(Resource.Success(cacheResponse))
        } else {
            try {
                val remoteResponse = remoteDataSource.getListings(limit, after, listingUrl)

                localDataSource.clearListingsLocalDataSource()
                localDataSource.insertIntoListingsLocalDataSource(remoteResponse, listingUrl)

                emit(Resource.Success(localDataSource.getListings(listingUrl)))
            } catch (e: HttpException) {
                emit(Resource.Error(message = "HttpException happened"))
            } catch (e: IOException) {
                emit(Resource.Error(message = "IOException happened"))
            } catch (e: Exception) {
                emit(Resource.Error(message = "Fatal error ${e.localizedMessage}"))
            }
        }
    }
}