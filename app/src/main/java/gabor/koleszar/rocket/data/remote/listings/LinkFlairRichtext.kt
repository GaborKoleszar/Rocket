package gabor.koleszar.rocket.data.remote.listings


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LinkFlairRichtext(
    @SerialName("a")
    val a: String?,
    @SerialName("e")
    val e: String?,
    @SerialName("t")
    val t: String?,
    @SerialName("u")
    val u: String?
)