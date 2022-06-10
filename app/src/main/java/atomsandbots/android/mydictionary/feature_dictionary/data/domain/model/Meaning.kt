package atomsandbots.android.mydictionary.feature_dictionary.data.domain.model

import atomsandbots.android.mydictionary.feature_dictionary.data.remote.dto.MeaningDto

data class Meaning(
    val definition: List<Definition>,
    val partOfSpeech: String
){
    fun toMeaning (): Meaning{
        return Meaning(
            //See if map to function is needed
            definition = definition,
            partOfSpeech = partOfSpeech
        )
    }
}
