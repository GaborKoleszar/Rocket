package gabor.koleszar.rocket.data.remote.listings

data class Post(
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
