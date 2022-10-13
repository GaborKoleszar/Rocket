package gabor.koleszar.rocket.feature_listings.presentation.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import gabor.koleszar.rocket.common.Resource
import gabor.koleszar.rocket.feature_listings.data.remote_datasource.RedditApi.Companion.BEST_LISTING_URL
import gabor.koleszar.rocket.feature_listings.domain.model.Listing
import gabor.koleszar.rocket.feature_listings.domain.repository.ListingsRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

const val LISTING_LIST = "listingList"

@HiltViewModel
class ListingViewModel @Inject constructor(
    private val listingsRepository: ListingsRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val listingList = savedStateHandle.getStateFlow(LISTING_LIST, emptyList<Listing>())

    init {
        loadPosts()
    }

    private fun loadPosts() {
        viewModelScope.launch {
            listingsRepository.getListings(listingUrl = BEST_LISTING_URL).onEach { response ->
                when (response) {
                    is Resource.Success -> {
                        savedStateHandle[LISTING_LIST] = response.data
                    }
                    else -> {}
                }
            }.launchIn(this)
        }
    }
}