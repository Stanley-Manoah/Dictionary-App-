package atomsandbots.android.mydictionary.feature_dictionary.data.repository

import atomsandbots.android.mydictionary.core.util.Resource
import atomsandbots.android.mydictionary.feature_dictionary.data.domain.WordInfo
import atomsandbots.android.mydictionary.feature_dictionary.data.domain.model.repository.WordInfoRepository
import atomsandbots.android.mydictionary.feature_dictionary.data.local.wordInfoDao
import atomsandbots.android.mydictionary.feature_dictionary.data.remote.DictionaryApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException

// Word info repository to get data from database to be displayed via View Model
class WordInfoRepositoryImpl (
    private val api: DictionaryApi,
    private val dao: wordInfoDao): WordInfoRepository {

        override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow{
            //Load info with progress bar
            emit(Resource.Loading())

            //Read cached words from Database
            val wordInfos =dao.getwordsinfo(word).map { it.toWordInfo() }
            emit(Resource.Loading(data = wordInfos))

            try{
                //make api call
                val remoteWordInfos = api.getWordInfo(word)
                //delete current UI and insert new words IN DB ready for display via MVVM
                dao.deletewordsinfos(remoteWordInfos.map { it.word })
                dao.insertWordInfos(remoteWordInfos.map { it.toWordInfoEntity() })

            }catch (e: HttpException){
                emit(Resource.Error(message = "Sorry, Something went wrong",
                    data = wordInfos))

            }catch (e: IOException){
                emit(Resource.Error(message = "Sorry, Something went wrong. Try and check you network connection please",
                    data = wordInfos))
            }

            //emit new data/words to UI
            val newWordInfos = dao.getwordsinfo(word).map{it.toWordInfo()}
            emit(Resource.Success(newWordInfos))

        }

}