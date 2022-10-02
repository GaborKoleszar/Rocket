package gabor.koleszar.rocket.feature_listings.presentation.states

import gabor.koleszar.rocket.feature_listings.data.remote_datasource.dtos.PostDto

data class ListingState(
    val listOfPosts: List<PostDto> = emptyList()
)
