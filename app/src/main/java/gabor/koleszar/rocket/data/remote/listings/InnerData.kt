package gabor.koleszar.rocket.data.remote.listings

import kotlinx.serialization.Serializable

@Serializable
data class InnerData(
    val subreddit: String,
    val selftext: String,
    val title: String,
    val score: Int,
    val created: Long,
    val author: String,
    val num_comments: Int,
    val permalink: String,
    val url: String
)
