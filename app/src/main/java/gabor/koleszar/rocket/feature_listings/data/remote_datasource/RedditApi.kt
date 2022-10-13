package gabor.koleszar.rocket.feature_listings.data.remote_datasource

import gabor.koleszar.rocket.feature_listings.data.remote_datasource.dtos.ListingsResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RedditApi {

    @GET(BEST_LISTING_URL)
    suspend fun getBestListing(
        @Query("limit") limit: Int,
        @Query("after") after: String?
    ): ListingsResponseDto

    @GET(HOT_LISTING_URL)
    suspend fun getHotListing(
        @Query("limit") limit: Int,
        @Query("after") after: String?
    ): ListingsResponseDto

    @GET(NEW_LISTING_URL)
    suspend fun getNewListing(
        @Query("limit") limit: Int,
        @Query("after") after: String?
    ): ListingsResponseDto

    @GET(TOP_LISTING_URL)
    suspend fun getTopListing(
        @Query("limit") limit: Int,
        @Query("after") after: String?
    ): ListingsResponseDto

    companion object {
        const val BASE_URL = "https://www.reddit.com/"
        const val BEST_LISTING_URL = "best.json"
        const val HOT_LISTING_URL = "hot.json"
        const val NEW_LISTING_URL = "new.json"
        const val TOP_LISTING_URL = "top.json"
    }
}