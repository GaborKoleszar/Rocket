package gabor.koleszar.rocket.data.remote.listings


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TournamentData(
    @SerialName("currency")
    val currency: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("predictions")
    val predictions: List<Prediction>,
    @SerialName("status")
    val status: String?,
    @SerialName("subreddit_id")
    val subredditId: String?,
    @SerialName("theme_id")
    val themeId: String?,
    @SerialName("total_participants")
    val totalParticipants: Int?,
    @SerialName("tournament_id")
    val tournamentId: String?
)