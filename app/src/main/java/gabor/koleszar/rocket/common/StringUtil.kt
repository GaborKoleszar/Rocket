package gabor.koleszar.rocket.common

object StringUtil {
    fun textShortener(text: String, maxLength: Int): String {
        return if (text.length <= maxLength)
            text
        else
            text.slice(0..maxLength) + "..."
    }
}