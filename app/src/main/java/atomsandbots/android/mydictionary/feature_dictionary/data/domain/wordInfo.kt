package atomsandbots.android.mydictionary.feature_dictionary.data.domain

import atomsandbots.android.mydictionary.feature_dictionary.data.domain.model.Meaning
import atomsandbots.android.mydictionary.feature_dictionary.data.remote.dto.MeaningDto
data class WordInfo(
    val meanings: List<Meaning>,
    val phonetic: String,
    val word: String
)
