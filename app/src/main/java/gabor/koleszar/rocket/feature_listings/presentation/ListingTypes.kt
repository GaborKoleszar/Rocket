package gabor.koleszar.rocket.feature_listings.presentation

import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import gabor.koleszar.rocket.common.StringUtil
import gabor.koleszar.rocket.feature_listings.data.remote_datasource.RedditApi.Companion.BEST_LISTING_URL
import gabor.koleszar.rocket.feature_listings.data.remote_datasource.RedditApi.Companion.HOT_LISTING_URL
import gabor.koleszar.rocket.feature_listings.data.remote_datasource.RedditApi.Companion.NEW_LISTING_URL
import gabor.koleszar.rocket.feature_listings.data.remote_datasource.RedditApi.Companion.TOP_LISTING_URL

sealed class ListingTypes(val url: String) {
    object HotListingType : ListingTypes(HOT_LISTING_URL)
    object BestListingType : ListingTypes(BEST_LISTING_URL)
    object NewListingType : ListingTypes(NEW_LISTING_URL)
    object TopListingType : ListingTypes(TOP_LISTING_URL)

    fun getName(): String   {
        return url.dropLast(5).capitalize(Locale.current)
    }
}
