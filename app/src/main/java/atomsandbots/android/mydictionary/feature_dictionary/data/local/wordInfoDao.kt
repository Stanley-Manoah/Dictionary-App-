package atomsandbots.android.mydictionary.feature_dictionary.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import atomsandbots.android.mydictionary.feature_dictionary.data.local.entity.WordInfoEntity

@Dao
interface wordInfoDao {

    //Insert word and if word already exists, REPLACE on conflict strategy
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWordInfos(infos: List<WordInfoEntity>)

    @Query("DELETE FROM wordinfoentity WHERE word IN (:words)")
    suspend fun deletewordsinfos(words: List<String>)

    @Query("SELECT * FROM wordinfoentity WHERE word LIKE '%' || :word || '%'")
    suspend fun getwordsinfo (word: String): List<WordInfoEntity>



}