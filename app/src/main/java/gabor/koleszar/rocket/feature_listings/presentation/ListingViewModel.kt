package gabor.koleszar.rocket.feature_listings.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import gabor.koleszar.rocket.common.Resource
import gabor.koleszar.rocket.feature_listings.domain.model.Listing
import gabor.koleszar.rocket.feature_listings.domain.repository.ListingsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

//const val SAVED_LIST_STATE_KEY = "listingListKey"

@HiltViewModel
class ListingViewModel @Inject constructor(
    private val listingsRepository: ListingsRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val listingTypeState = mutableStateOf<ListingTypes>(ListingTypes.BestListingType)

    private val _listingItems = MutableStateFlow(emptyList<Listing>())
    val listingItems = _listingItems.asStateFlow()

    private fun loadPosts(listingType: ListingTypes) {
        viewModelScope.launch {
            listingsRepository.getListings(listingUrl = listingType.url).onEach { response ->
                when (response) {
                    is Resource.Success -> {
                        _listingItems.value = response.data!!
                    }
                    is Resource.Error -> { /* TODO */ }
                    is Resource.Loading -> { /* TODO */ }
                }
            }.launchIn(this)
        }
    }

    fun setListingType(listingType: ListingTypes) {
        listingTypeState.value = listingType
        loadPosts(listingTypeState.value)
    }
}