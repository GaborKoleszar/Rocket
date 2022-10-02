package gabor.koleszar.rocket.feature_listings.data.remote_datasource

import gabor.koleszar.rocket.feature_listings.data.remote_datasource.dtos.PostDto

interface RedditApi {

    suspend fun getBestListing(numberOfPosts: Int = 10, after: String? = null): List<PostDto>

    companion object {
        const val BASE_URL = "www.reddit.com"
        const val BEST_LISTING_URL = "best.json"
    }
}