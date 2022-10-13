package gabor.koleszar.rocket.feature_listings.data.remote_datasource.dtos


data class DataDto(
    val dist: Int,
    val children: List<InnerDataDto>
)