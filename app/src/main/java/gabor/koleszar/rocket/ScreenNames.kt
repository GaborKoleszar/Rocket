package gabor.koleszar.rocket

sealed class ScreenNames(val path: String) {
    object ListingsScreen : ScreenNames("ListingsScreen")
}