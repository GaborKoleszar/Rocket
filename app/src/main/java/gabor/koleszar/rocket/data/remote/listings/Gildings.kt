package gabor.koleszar.rocket.data.remote.listings


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Gildings(
    @SerialName("gid_1")
    val gid1: Int?,
    @SerialName("gid_2")
    val gid2: Int?
)