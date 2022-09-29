package gabor.koleszar.rocket.data.remote.listings


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Listing(
    @SerialName("data")
    val data: Data,
    @SerialName("kind")
    val kind: String?
)