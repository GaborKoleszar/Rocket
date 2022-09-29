package gabor.koleszar.rocket.data.remote.listings


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Preview(
    @SerialName("enabled")
    val enabled: Boolean?,
    @SerialName("images")
    val images: List<Image>
)