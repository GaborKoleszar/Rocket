package gabor.koleszar.rocket.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import gabor.koleszar.rocket.presentation.screens.ListingScreen
import gabor.koleszar.rocket.presentation.theme.RocketTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RocketTheme {
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