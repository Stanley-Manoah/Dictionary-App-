package atomsandbots.android.mydictionary.feature_dictionary.data.domain.model.repository.use_case

import atomsandbots.android.mydictionary.core.util.Resource
import atomsandbots.android.mydictionary.feature_dictionary.data.domain.WordInfo
import atomsandbots.android.mydictionary.feature_dictionary.data.domain.model.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class getWordInfo(
    private val repository: WordInfoRepository
) {
    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>>{
        //if there is no search don't make an api call
        if(word.isBlank()){
            return flow {  }
        }
        //else return word/s from my repository
        return repository.getWordInfo(word)

    }
}