package gabor.koleszar.rocket.data.remote

import gabor.koleszar.rocket.data.remote.listings.Listing
import io.ktor.client.statement.*

interface RedditApi {

    suspend fun getBestListing(): HttpResponse

    companion object {
        const val BASE_URL = "www.reddit.com"
        const val BEST_LISTING_URL = "best.json"
    }
}