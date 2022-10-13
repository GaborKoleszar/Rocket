package gabor.koleszar.rocket.feature_listings.data.local_datasource

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ListingEntity::class],
    version = 1,
    exportSchema = false
)
abstract class RedditDataBase : RoomDatabase() {
    abstract val redditDao: RedditDao

    companion object{
        const val DATABASE_NAME = "reddit_db"
    }
}