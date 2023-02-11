package gabor.koleszar.rocket.feature_listings.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun ListingScreen(
    listingType: ListingTypes,
    navController: NavController,
    viewModel: ListingViewModel = hiltViewModel()
) {
    val listState = rememberLazyListState()
    val listingList by viewModel.listingList.collectAsState()
    if (listingList.isEmpty())
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        }
    else {
        LazyColumn(state = listState, modifier = Modifier.fillMaxSize()) {
            items(items = listingList,
                itemContent = { post ->
                    ListingCard(post = post)
                })
        }
    }
}