package gabor.koleszar.rocket.presentation.states

import gabor.koleszar.rocket.data.remote.listings.InnerData

data class ListingState(
    val listOfPosts: List<InnerData> = emptyList()
)
