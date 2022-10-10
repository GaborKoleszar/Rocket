package gabor.koleszar.rocket.feature_listings.data.local_datasource

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ListingEntity(
    @PrimaryKey val id: Int? = null,
    val author: String,
    val created: Long,
    val downs: Int,
    val isVideo: Boolean,
    val likes: Boolean? = null,
    val numComments: Int,
    val permalink: String,
    val postHint: String,
    val score: Int,
    val selftext: String,
    val title: String,
    val ups: Int,
    val url: String,
    val subreddit: String,
    val timestampInserted: Long
)