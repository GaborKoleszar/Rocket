package gabor.koleszar.rocket.data.remote.listings


import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("after")
    val after: String?,
    @SerialName("before")
    @Contextual
    val before: Any?,
    @SerialName("children")
    val children: List<Children>,
    @SerialName("dist")
    val dist: Int?,
    @SerialName("geo_filter")
    @Contextual
    val geoFilter: Any?,
    @SerialName("modhash")
    val modhash: String?
)