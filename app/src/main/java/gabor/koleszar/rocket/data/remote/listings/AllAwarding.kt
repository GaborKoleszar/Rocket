package gabor.koleszar.rocket.data.remote.listings


import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AllAwarding(
    @SerialName("award_sub_type")
    val awardSubType: String?,
    @SerialName("award_type")
    val awardType: String?,
    @SerialName("awardings_required_to_grant_benefits")
    @Contextual
    val awardingsRequiredToGrantBenefits: Any?,
    @SerialName("coin_price")
    val coinPrice: Int?,
    @SerialName("coin_reward")
    val coinReward: Int?,
    @SerialName("count")
    val count: Int?,
    @SerialName("days_of_drip_extension")
    @Contextual
    val daysOfDripExtension: Any?,
    @SerialName("days_of_premium")
    val daysOfPremium: Int?,
    @SerialName("description")
    val description: String?,
    @SerialName("end_date")
    @Contextual
    val endDate: Any?,
    @SerialName("giver_coin_reward")
    @Contextual
    val giverCoinReward: Any?,
    @SerialName("icon_format")
    val iconFormat: String?,
    @SerialName("icon_height")
    val iconHeight: Int?,
    @SerialName("icon_url")
    val iconUrl: String?,
    @SerialName("icon_width")
    val iconWidth: Int?,
    @SerialName("id")
    val id: String?,
    @SerialName("is_enabled")
    val isEnabled: Boolean?,
    @SerialName("is_new")
    val isNew: Boolean?,
    @SerialName("name")
    val name: String?,
    @SerialName("penny_donate")
    @Contextual
    val pennyDonate: Any?,
    @SerialName("penny_price")
    val pennyPrice: Int?,
    @SerialName("resized_icons")
    val resizedIcons: List<ResizedIcon>,
    @SerialName("resized_static_icons")
    val resizedStaticIcons: List<ResizedStaticIcon>,
    @SerialName("start_date")
    @Contextual
    val startDate: Any?,
    @SerialName("static_icon_height")
    val staticIconHeight: Int?,
    @SerialName("static_icon_url")
    val staticIconUrl: String?,
    @SerialName("static_icon_width")
    val staticIconWidth: Int?,
    @SerialName("sticky_duration_seconds")
    @Contextual
    val stickyDurationSeconds: Any?,
    @SerialName("subreddit_coin_reward")
    val subredditCoinReward: Int?,
    @SerialName("subreddit_id")
    @Contextual
    val subredditId: Any?,
    @SerialName("tiers_by_required_awardings")
    @Contextual
    val tiersByRequiredAwardings: Any?
)