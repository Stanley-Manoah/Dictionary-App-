package atomsandbots.android.mydictionary.feature_dictionary.data.domain.model.repository

import atomsandbots.android.mydictionary.core.util.Resource
import atomsandbots.android.mydictionary.feature_dictionary.data.domain.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {

    fun getWordInfo (word: String): Flow<Resource<List<WordInfo>>>
}