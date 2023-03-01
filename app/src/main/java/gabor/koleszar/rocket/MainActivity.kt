package gabor.koleszar.rocket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import gabor.koleszar.rocket.feature_listings.presentation.ListingScreen
import gabor.koleszar.rocket.feature_listings.presentation.ListingTypes
import gabor.koleszar.rocket.theme.RocketTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

