package gabor.koleszar.rocket.feature_listings.data.remote_datasource

import gabor.koleszar.rocket.feature_listings.data.remote_datasource.dtos.ListingDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ListingsRemoteDataSource @Inject constructor(
    private val redditApi: RedditApi
) {
    suspend fun getListings(
        limit: Int,
        after: String?,
        listingUrl: String
    ): List<ListingDto> {
        return withContext(Dispatchers.IO) {
            when (listingUrl) {
                RedditApi.BEST_LISTING_URL -> return@withContext redditApi.getBestListing(
                    limit,
                    after
                ).data.children.map { it.data }

                RedditApi.TOP_LISTING_URL -> return@withContext redditApi.getTopListing(
                    limit,
                    after
                ).data.children.map { it.data }

                RedditApi.NEW_LISTING_URL -> return@withContext redditApi.getNewListing(
                    limit,
                    after
                ).data.children.map { it.data }

                RedditApi.HOT_LISTING_URL -> return@withContext redditApi.getHotListing(
                    limit,
                    after
                ).data.children.map { it.data }

                //DEFAULT CASE
                else -> return@withContext redditApi.getBestListing(
                    limit,
                    after
                ).data.children.map { it.data }
            }
        }
    }
}