package gabor.koleszar.rocket.data.remote.listings


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthorFlairRichtext(
    @SerialName("e")
    val e: String?,
    @SerialName("t")
    val t: String?
)