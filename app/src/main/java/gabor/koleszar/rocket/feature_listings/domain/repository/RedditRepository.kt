package gabor.koleszar.rocket.feature_listings.domain.repository

import gabor.koleszar.rocket.common.Resource
import gabor.koleszar.rocket.feature_listings.domain.model.Listing
import kotlinx.coroutines.flow.Flow

interface RedditRepository {

    suspend fun getListings(
        limit: Int = 50,
        after: String? = null
    ): Flow<Resource<List<Listing>>>
}