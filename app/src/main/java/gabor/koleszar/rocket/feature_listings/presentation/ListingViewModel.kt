package gabor.koleszar.rocket.feature_listings.presentation

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import gabor.koleszar.rocket.common.Resource
import gabor.koleszar.rocket.feature_listings.domain.model.Listing
import gabor.koleszar.rocket.feature_listings.domain.repository.ListingsRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

const val SAVED_LIST_STATE_KEY = "listingListKey"

@HiltViewModel
class ListingViewModel @Inject constructor(
    private val listingsRepository: ListingsRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val listingTypeState = mutableStateOf<ListingTypes>(ListingTypes.BestListingType)
    val listingList = savedStateHandle.getStateFlow(SAVED_LIST_STATE_KEY, emptyList<Listing>())

    val testVariable = mutableStateOf(false)

    init {
        setListingType(ListingTypes.BestListingType)
    }

    private fun loadPosts(listingType: ListingTypes) {
        Log.d("From viewmodel: ", "testVariable: " + testVariable.value.toString())
        viewModelScope.launch {
            listingsRepository.getListings(listingUrl = listingType.url).onEach { response ->
                when (response) {
                    is Resource.Success -> {
                        savedStateHandle[SAVED_LIST_STATE_KEY] = response.data
                    }

                    else -> {}
                }
            }.launchIn(this)
        }
    }

    fun setListingType(listingType: ListingTypes) {
        listingTypeState.value = listingType
        loadPosts(listingTypeState.value)
    }
}