package gabor.koleszar.rocket.feature_listings.data.local_datasource

import androidx.room.Entity
import androidx.room.PrimaryKey
import gabor.koleszar.rocket.feature_listings.domain.model.Listing
import java.text.SimpleDateFormat
import java.util.*

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
    val timestampInserted: Long,
    val listingUrl: String
) {
    fun toListing(simpleDateFormat: SimpleDateFormat): Listing {
        return Listing(
            author = "u/$author",
            created = simpleDateFormat.format(Date(created * 1000)),
            downs = downs,
            isVideo = isVideo,
            likes = likes,
            numComments = numComments,
            permalink = permalink,
            postHint = postHint,
            score = score,
            selftext = selftext,
            title = title,
            ups = ups,
            url = url,
            subreddit = subreddit,
            timestampInserted = timestampInserted
        )
    }
}