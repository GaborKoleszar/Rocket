package gabor.koleszar.rocket.feature_listings.data.remote_datasource.dtos

import com.google.gson.annotations.SerializedName

data class DataDto(
    val dist: Int,
    @SerializedName("children")
    val postList: List<InnerDataDto>
)