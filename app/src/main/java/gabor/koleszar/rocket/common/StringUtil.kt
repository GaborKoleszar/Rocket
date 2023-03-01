package gabor.koleszar.rocket.common

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object StringUtil {

    @SuppressLint("ConstantLocale")
    private val simpleDateFormat = SimpleDateFormat("h:mm", Locale.getDefault())
    fun textShortener(text: String, maxLength: Int): String {
        return if (text.length <= maxLength)
            text
        else
            text.slice(0..maxLength) + "..."
    }

    fun formatDate(date : Date) : String  {
        return simpleDateFormat.format(date)
    }
}