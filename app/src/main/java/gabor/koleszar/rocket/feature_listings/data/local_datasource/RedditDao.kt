package gabor.koleszar.rocket.feature_listings.data.local_datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RedditDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListings(
        listings: List<ListingEntity>
    )

    @Query("DELETE FROM listingentity")
    suspend fun clearListings()

    @Query("SELECT * FROM listingentity WHERE listingUrl LIKE :listingUrl")
    suspend fun getListings(listingUrl: String): List<ListingEntity>
}