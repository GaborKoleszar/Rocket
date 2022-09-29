package gabor.koleszar.rocket.data.remote.listings


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Image(
    @SerialName("id")
    val id: String?,
    @SerialName("resolutions")
    val resolutions: List<Resolution>,
    @SerialName("source")
    val source: Source,
    @SerialName("variants")
    val variants: Variants
)