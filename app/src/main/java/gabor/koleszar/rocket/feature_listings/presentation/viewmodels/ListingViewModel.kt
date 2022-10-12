package gabor.koleszar.rocket.feature_listings.presentation.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import gabor.koleszar.rocket.common.Resource
import gabor.koleszar.rocket.feature_listings.domain.model.Listing
import gabor.koleszar.rocket.feature_listings.domain.repository.RedditRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import javax.inject.Inject

@HiltViewModel
class ListingViewModel @Inject constructor(
    private val redditRepository: RedditRepository,
    private val savedStateHandle: SavedStateHandle,
    val simpleDateFormat: SimpleDateFormat
) : ViewModel() {

    val listingList = savedStateHandle.getStateFlow("listingList", emptyList<Listing>())

    init {
        loadPosts()
    }

    private fun loadPosts() {
        viewModelScope.launch {
            redditRepository.getListings().onEach { response ->
                when (response) {
                    is Resource.Success -> {
                        savedStateHandle["listingList"] = response.data
                    }
                    else -> {}
                }
            }.launchIn(this)
        }
    }
}