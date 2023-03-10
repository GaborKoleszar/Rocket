package gabor.koleszar.rocket

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import gabor.koleszar.rocket.feature_listings.presentation.ListingScreen
import gabor.koleszar.rocket.feature_listings.presentation.ListingTypes
import gabor.koleszar.rocket.feature_listings.presentation.ListingViewModel
import gabor.koleszar.rocket.theme.RocketTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: ListingViewModel by viewModels()
        installSplashScreen()
        viewModel.testVariable.value = true
        Log.d("From activity: ", "testVariable: " + viewModel.testVariable.value.toString())
        setContent {
            RocketTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = ScreenNames.ListingsScreen.path
                ) {
                    composable(route = ScreenNames.ListingsScreen.path) {
                        ListingScreen(
                            listingType = ListingTypes.BestListingType,
                            navController = navController
                        )
                    }
                }
            }
        }

    }
}

