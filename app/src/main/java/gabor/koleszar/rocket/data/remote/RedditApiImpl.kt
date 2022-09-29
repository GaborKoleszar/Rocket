package gabor.koleszar.rocket.data.remote

import gabor.koleszar.rocket.data.remote.RedditApi.Companion.BASE_URL
import gabor.koleszar.rocket.data.remote.RedditApi.Companion.BEST_LISTING_URL
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

class RedditApiImpl(
    private val client: HttpClient
) : RedditApi {

    override suspend fun getBestListing(): HttpResponse {
        return client.get {
            url {
                protocol = URLProtocol.HTTPS
                host = BASE_URL
                path(BEST_LISTING_URL)
                parameters.append("limit", "5")
            }
            headers {
                append(
                    HttpHeaders.UserAgent,
                    "Contact: kgabi92@gmail.com - Using for learning purposes"
                )
            }
        }
    }
}