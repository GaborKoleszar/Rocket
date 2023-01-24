package gabor.koleszar.rocket.feature_listings.presentation.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import gabor.koleszar.rocket.feature_listings.presentation.viewmodels.ListingViewModel

@Composable
fun HotListingScreen(
    navController: NavController,
    viewModel: ListingViewModel = hiltViewModel()
)  {
    ListingScreen(
        navController = navController,
        viewModel = viewModel
    )
}