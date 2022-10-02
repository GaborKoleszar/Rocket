package gabor.koleszar.rocket

sealed class ScreenNames(val path: String) {
    object ListingScreen : ScreenNames("ListingScreen")
}