package gabor.koleszar.rocket.feature_listings.data.local_datasource

import gabor.koleszar.rocket.feature_listings.data.remote_datasource.dtos.ListingDto
import gabor.koleszar.rocket.feature_listings.domain.model.Listing
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

const val CACHE_EXPIRATION_MILLISECOND = 1200000

class ListingsLocalDataSource @Inject constructor(
    private val redditDb: RedditDataBase
) {
    suspend fun getListings(listingUrl: String): List<Listing>? {
        return withContext(Dispatchers.IO) {
            val cachedResponse =
                redditDb.redditDao.getListings(listingUrl).map { it.toListing() }
            if (cachedResponse.isNotEmpty() && System.currentTimeMillis() - cachedResponse[0].timestampInserted < CACHE_EXPIRATION_MILLISECOND)
                return@withContext cachedResponse
            else
                return@withContext null
        }
    }

    suspend fun clearListingsLocalDataSource() {
        withContext(Dispatchers.IO) {
            redditDb.redditDao.clearListings()
        }
    }

    suspend fun insertIntoListingsLocalDataSource(
        remoteResponse: List<ListingDto>,
        listingUrl: String
    ) {
        withContext(Dispatchers.IO) {
            redditDb.redditDao.insertListings(remoteResponse.map { it.toListingEntity(listingUrl) })
        }
    }
}