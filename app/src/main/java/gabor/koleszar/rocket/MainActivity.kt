package gabor.koleszar.rocket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import gabor.koleszar.rocket.feature_listings.presentation.ListingScreen
import gabor.koleszar.rocket.feature_listings.presentation.ListingTypes
import gabor.koleszar.rocket.feature_listings.presentation.ListingViewModel
import gabor.koleszar.rocket.theme.RocketTheme
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val listingViewModel: ListingViewModel by viewModels()

    //TODO implement user preferences
    private val defaultListing = ListingTypes.BestListingType

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                listingViewModel.setListingType(defaultListing)
            }
        }

        splashScreen.setKeepOnScreenCondition {
                listingViewModel.listingList.value.isEmpty()
        }

        setContent {
            RocketTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = ScreenNames.ListingsScreen.path
                ) {
                    composable(route = ScreenNames.ListingsScreen.path) {
                        ListingScreen(
                            navController = navController,
                            viewModel = listingViewModel
                        )
                    }
                }
            }
        }
    }
}

