package gabor.koleszar.rocket.data.remote.listings


import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DataInner(
    @SerialName("all_awardings")
    val allAwardings: List<AllAwarding>,
    @SerialName("allow_live_comments")
    val allowLiveComments: Boolean?,
    @SerialName("approved_at_utc")
    @Contextual
    val approvedAtUtc: Any?,
    @SerialName("approved_by")
    @Contextual
    val approvedBy: Any?,
    @SerialName("archived")
    val archived: Boolean?,
    @SerialName("author")
    val author: String?,
    @SerialName("author_flair_background_color")
    val authorFlairBackgroundColor: String?,
    @SerialName("author_flair_css_class")
    @Contextual
    val authorFlairCssClass: Any?,
    @SerialName("author_flair_richtext")
    val authorFlairRichtext: List<AuthorFlairRichtext>,
    @SerialName("author_flair_template_id")
    val authorFlairTemplateId: String?,
    @SerialName("author_flair_text")
    val authorFlairText: String?,
    @SerialName("author_flair_text_color")
    val authorFlairTextColor: String?,
    @SerialName("author_flair_type")
    val authorFlairType: String?,
    @SerialName("author_fullname")
    val authorFullname: String?,
    @SerialName("author_is_blocked")
    val authorIsBlocked: Boolean?,
    @SerialName("author_patreon_flair")
    val authorPatreonFlair: Boolean?,
    @SerialName("author_premium")
    val authorPremium: Boolean?,
    @SerialName("awarders")
    val awarders: List<@Contextual Any>,
    @SerialName("banned_at_utc")
    @Contextual
    val bannedAtUtc: Any?,
    @SerialName("banned_by")
    @Contextual
    val bannedBy: Any?,
    @SerialName("can_gild")
    val canGild: Boolean?,
    @SerialName("can_mod_post")
    val canModPost: Boolean?,
    @SerialName("category")
    @Contextual
    val category: Any?,
    @SerialName("clicked")
    val clicked: Boolean?,
    @SerialName("content_categories")
    @Contextual
    val contentCategories: Any?,
    @SerialName("contest_mode")
    val contestMode: Boolean?,
    @SerialName("created")
    val created: Double?,
    @SerialName("created_utc")
    val createdUtc: Double?,
    @SerialName("discussion_type")
    @Contextual
    val discussionType: Any?,
    @SerialName("distinguished")
    @Contextual
    val distinguished: Any?,
    @SerialName("domain")
    val domain: String?,
    @SerialName("downs")
    val downs: Int?,
    @SerialName("edited")
    val edited: Boolean?,
    @SerialName("gilded")
    val gilded: Int?,
    @SerialName("gildings")
    val gildings: Gildings?,
    @SerialName("hidden")
    val hidden: Boolean?,
    @SerialName("hide_score")
    val hideScore: Boolean?,
    @SerialName("id")
    val id: String?,
    @SerialName("is_created_from_ads_ui")
    val isCreatedFromAdsUi: Boolean?,
    @SerialName("is_crosspostable")
    val isCrosspostable: Boolean?,
    @SerialName("is_meta")
    val isMeta: Boolean?,
    @SerialName("is_original_content")
    val isOriginalContent: Boolean?,
    @SerialName("is_reddit_media_domain")
    val isRedditMediaDomain: Boolean?,
    @SerialName("is_robot_indexable")
    val isRobotIndexable: Boolean?,
    @SerialName("is_self")
    val isSelf: Boolean?,
    @SerialName("is_video")
    val isVideo: Boolean?,
    @SerialName("likes")
    @Contextual
    val likes: Any?,
    @SerialName("link_flair_background_color")
    val linkFlairBackgroundColor: String?,
    @SerialName("link_flair_css_class")
    val linkFlairCssClass: String?,
    @SerialName("link_flair_richtext")
    val linkFlairRichtext: List<LinkFlairRichtext>,
    @SerialName("link_flair_template_id")
    val linkFlairTemplateId: String?,
    @SerialName("link_flair_text")
    val linkFlairText: String?,
    @SerialName("link_flair_text_color")
    val linkFlairTextColor: String?,
    @SerialName("link_flair_type")
    val linkFlairType: String?,
    @SerialName("locked")
    val locked: Boolean?,
    @SerialName("media")
    @Contextual
    val media: Any?,
    @SerialName("media_embed")
    val mediaEmbed: MediaEmbed,
    @SerialName("media_only")
    val mediaOnly: Boolean?,
    @SerialName("mod_note")
    @Contextual
    val modNote: Any?,
    @SerialName("mod_reason_by")
    @Contextual
    val modReasonBy: Any?,
    @SerialName("mod_reason_title")
    @Contextual
    val modReasonTitle: Any?,
    @SerialName("mod_reports")
    val modReports: List<@Contextual Any>,
    @SerialName("name")
    val name: String?,
    @SerialName("no_follow")
    val noFollow: Boolean?,
    @SerialName("num_comments")
    val numComments: Int?,
    @SerialName("num_crossposts")
    val numCrossposts: Int?,
    @SerialName("num_reports")
    @Contextual
    val numReports: Any?,
    @SerialName("over_18")
    val over18: Boolean?,
    @SerialName("parent_whitelist_status")
    val parentWhitelistStatus: String?,
    @SerialName("permalink")
    val permalink: String?,
    @SerialName("pinned")
    val pinned: Boolean?,
    @SerialName("post_hint")
    val postHint: String?,
    @SerialName("preview")
    val preview: Preview,
    @SerialName("pwls")
    val pwls: Int?,
    @SerialName("quarantine")
    val quarantine: Boolean?,
    @SerialName("removal_reason")
    @Contextual
    val removalReason: Any?,
    @SerialName("removed_by")
    @Contextual
    val removedBy: Any?,
    @SerialName("removed_by_category")
    @Contextual
    val removedByCategory: Any?,
    @SerialName("report_reasons")
    @Contextual
    val reportReasons: Any?,
    @SerialName("saved")
    val saved: Boolean?,
    @SerialName("score")
    val score: Int?,
    @SerialName("secure_media")
    @Contextual
    val secureMedia: Any?,
    @SerialName("secure_media_embed")
    val secureMediaEmbed: SecureMediaEmbed,
    @SerialName("selftext")
    val selftext: String?,
    @SerialName("selftext_html")
    val selftextHtml: String?,
    @SerialName("send_replies")
    val sendReplies: Boolean?,
    @SerialName("spoiler")
    val spoiler: Boolean?,
    @SerialName("stickied")
    val stickied: Boolean?,
    @SerialName("subreddit")
    val subreddit: String?,
    @SerialName("subreddit_id")
    val subredditId: String?,
    @SerialName("subreddit_name_prefixed")
    val subredditNamePrefixed: String?,
    @SerialName("subreddit_subscribers")
    val subredditSubscribers: Int?,
    @SerialName("subreddit_type")
    val subredditType: String?,
    @SerialName("suggested_sort")
    val suggestedSort: String?,
    @SerialName("thumbnail")
    val thumbnail: String?,
    @SerialName("thumbnail_height")
    val thumbnailHeight: Int?,
    @SerialName("thumbnail_width")
    val thumbnailWidth: Int?,
    @SerialName("title")
    val title: String?,
    @SerialName("top_awarded_type")
    @Contextual
    val topAwardedType: Any?,
    @SerialName("total_awards_received")
    val totalAwardsReceived: Int?,
    @SerialName("tournament_data")
    val tournamentData: TournamentData,
    @SerialName("treatment_tags")
    val treatmentTags: List<@Contextual Any?>,
    @SerialName("ups")
    val ups: Int?,
    @SerialName("upvote_ratio")
    val upvoteRatio: Double?,
    @SerialName("url")
    val url: String?,
    @SerialName("url_overridden_by_dest")
    val urlOverriddenByDest: String?,
    @SerialName("user_reports")
    @Contextual
    val userReports: List<@Contextual Any?>,
    @SerialName("view_count")
    @Contextual
    val viewCount: Any?,
    @SerialName("visited")
    val visited: Boolean?,
    @SerialName("whitelist_status")
    val whitelistStatus: String?,
    @SerialName("wls")
    val wls: Int?
)