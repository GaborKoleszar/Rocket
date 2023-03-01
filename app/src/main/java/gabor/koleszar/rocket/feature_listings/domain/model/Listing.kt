package gabor.koleszar.rocket.feature_listings.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class Listing(
    val author: String,
    val created: Date,
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
) : Parcelable