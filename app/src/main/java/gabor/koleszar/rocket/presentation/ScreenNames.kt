package gabor.koleszar.rocket.presentation

sealed class ScreenNames(val path: String) {
    object ListingScreen : ScreenNames("ListingScreen")
}