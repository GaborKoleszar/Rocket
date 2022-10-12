package gabor.koleszar.rocket.feature_listings.data.remote_datasource.dtos

import gabor.koleszar.rocket.feature_listings.data.local_datasource.ListingEntity

data class ListingDto(
    val author: String,
    val created: Long,
    val downs: Int,
    val is_video: Boolean,
    val likes: Boolean? = null,
    val name: String,
    val num_comments: Int,
    val permalink: String,
    val post_hint: String?,
    val score: Int,
    val selftext: String,
    val title: String,
    val ups: Int,
    val url: String,
    val subreddit: String
) {
    fun toListingEntity(): ListingEntity {
        return ListingEntity(
            author = author,
            created = created,
            downs = downs,
            isVideo = is_video,
            likes = likes,
            numComments = num_comments,
            permalink = permalink,
            postHint = post_hint ?: "",
            score = score,
            selftext = selftext,
            title = title,
            ups = ups,
            url = url,
            subreddit = subreddit,
            timestampInserted = System.currentTimeMillis()
        )
    }
}
