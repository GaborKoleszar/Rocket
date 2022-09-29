package gabor.koleszar.rocket.data.remote.listings


import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Prediction(
    @SerialName("body")
    val body: String?,
    @SerialName("created_at")
    val createdAt: Long,
    @SerialName("id")
    val id: String?,
    @SerialName("is_nsfw")
    val isNsfw: Boolean?,
    @SerialName("is_rtjson")
    val isRtjson: Boolean?,
    @SerialName("is_spoiler")
    val isSpoiler: Boolean?,
    @SerialName("options")
    val options: List<Option>,
    @SerialName("resolved_option_id")
    val resolvedOptionId: String?,
    @SerialName("status")
    val status: String?,
    @SerialName("title")
    val title: String?,
    @SerialName("total_stake_amount")
    val totalStakeAmount: Int?,
    @SerialName("total_vote_count")
    val totalVoteCount: Int?,
    @SerialName("user_selection")
    @Contextual
    val userSelection: Any?,
    @SerialName("user_won_amount")
    @Contextual
    val userWonAmount: Any?,
    @SerialName("vote_updates_remained")
    @Contextual
    val voteUpdatesRemained: Any?,
    @SerialName("voting_end_timestamp")
    val votingEndTimestamp: Long
)