package gabor.koleszar.rocket.data.remote.listings


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResizedIcon(
    @SerialName("height")
    val height: Int?,
    @SerialName("url")
    val url: String?,
    @SerialName("width")
    val width: Int?
)