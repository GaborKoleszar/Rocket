package gabor.koleszar.rocket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import gabor.koleszar.rocket.feature_listings.presentation.screens.ListingScreen
import gabor.koleszar.rocket.theme.RocketTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RocketTheme {
                Scaffold {
                    Box(modifier = Modifier.padding(it)) {
                        val navController = rememberNavController()
                        NavHost(
                            navController = navController,
                            startDestination = ScreenNames.ListingScreen.path
                        ) {
                            composable(route = ScreenNames.ListingScreen.path) {
                                ListingScreen(navController = navController)
                            }
                        }
                    }
                }
            }
        }
    }
}