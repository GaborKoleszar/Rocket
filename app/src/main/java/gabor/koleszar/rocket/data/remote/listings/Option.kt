package gabor.koleszar.rocket.data.remote.listings


import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Option(
    @SerialName("id")
    val id: String?,
    @SerialName("image_url")
    @Contextual
    val imageUrl: Any?,
    @SerialName("text")
    val text: String?,
    @SerialName("total_amount")
    val totalAmount: Int?,
    @SerialName("user_amount")
    @Contextual
    val userAmount: Any?,
    @SerialName("vote_count")
    val voteCount: Int?
)