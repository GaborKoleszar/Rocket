package gabor.koleszar.rocket.feature_listings.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import gabor.koleszar.rocket.feature_listings.data.remote_datasource.RedditApi
import gabor.koleszar.rocket.feature_listings.presentation.states.ListingState
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListingViewModel @Inject constructor(
    private val redditApi: RedditApi
) : ViewModel() {

    private val _listing = mutableStateOf(ListingState())
    val listing: State<ListingState> = _listing

    init {
        loadPosts()
    }

    private fun loadPosts() {
        viewModelScope.launch {
            _listing.value = listing.value.copy(
                listOfPosts = redditApi.getBestListing(numberOfPosts = 50, after = null)
            )
        }
    }
}