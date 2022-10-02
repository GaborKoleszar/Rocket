package gabor.koleszar.rocket.feature_listings.data.remote_datasource.dtos

data class PostDto(
    val author: String,
    val created: Long,
    val downs: Int,
    val is_video: Boolean,
    val likes: Boolean? = null,
    val name: String,
    val num_comments: Int,
    val permalink: String,
    val post_hint: String,
    val score: Int,
    val selftext: String,
    val title: String,
    val ups: Int,
    val url: String,
    val subreddit: String
)
