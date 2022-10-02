package gabor.koleszar.rocket.feature_listings.data.remote_datasource

import android.util.Log
import gabor.koleszar.rocket.feature_listings.data.remote_datasource.RedditApi.Companion.BASE_URL
import gabor.koleszar.rocket.feature_listings.data.remote_datasource.RedditApi.Companion.BEST_LISTING_URL
import gabor.koleszar.rocket.feature_listings.data.remote_datasource.dtos.Listing
import gabor.koleszar.rocket.feature_listings.data.remote_datasource.dtos.PostDto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class RedditApiImpl(
    private val client: HttpClient
) : RedditApi {

    override suspend fun getBestListing(numberOfPosts: Int, after: String?): List<PostDto> {
        val postListResponse = mutableListOf<PostDto>()
        try {
            (client.get {
                url {
                    protocol = URLProtocol.HTTPS
                    host = BASE_URL
                    path(BEST_LISTING_URL)
                    parameters.append("limit", numberOfPosts.toString())
                    after?.let { parameters.append("after", it) }
                }
                headers {
                    append(
                        HttpHeaders.UserAgent,
                        "Contact: kgabi92@gmail.com - Using for learning purposes"
                    )
                }
            }.body() as Listing).data.postList.map { post ->
                postListResponse.add(post.data)
            }
            return postListResponse
        } catch (e: Exception) {
            Log.d("RedditApi", "Error occured in the api call. (Response malformed)")
            return emptyList()
        }
    }
}