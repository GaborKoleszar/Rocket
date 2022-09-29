package gabor.koleszar.rocket.data.remote.listings

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val dist: Int,
    val children: List<InnerData>
)
