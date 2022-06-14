package atomsandbots.android.mydictionary.feature_dictionary.data.local

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import atomsandbots.android.mydictionary.feature_dictionary.data.local.entity.WordInfoEntity

@Database(
    version = 2,
    entities = [WordInfoEntity::class],
    autoMigrations = [
        AutoMigration (from = 1, to = 2)
    ],exportSchema = true
)
@TypeConverters(Converters::class)
abstract class WordInfoDatabase: RoomDatabase() {

    abstract val dao: wordInfoDao
}