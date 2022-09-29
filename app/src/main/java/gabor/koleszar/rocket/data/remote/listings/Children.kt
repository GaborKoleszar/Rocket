package gabor.koleszar.rocket.data.remote.listings


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Children(
    @SerialName("data")
    val data: DataInner,
    @SerialName("kind")
    val kind: String?
)