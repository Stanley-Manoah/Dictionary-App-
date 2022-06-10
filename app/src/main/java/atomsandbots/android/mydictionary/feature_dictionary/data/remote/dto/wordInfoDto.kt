import atomsandbots.android.mydictionary.feature_dictionary.data.local.entity.WordInfoEntity
import atomsandbots.android.mydictionary.feature_dictionary.data.remote.dto.MeaningDto
import atomsandbots.android.mydictionary.feature_dictionary.data.remote.dto.PhoneticDto

data class WordInfoDto(
    val meanings: List<MeaningDto>,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val word: String
) {
    fun toWordInfoEntity(): WordInfoEntity {
        return WordInfoEntity(
            meanings = meanings.map { it.toMeaning() },
            phonetic = phonetic,
            word = word
        )
    }
}