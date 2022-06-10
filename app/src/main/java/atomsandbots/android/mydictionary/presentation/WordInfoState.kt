package atomsandbots.android.mydictionary.presentation

import atomsandbots.android.mydictionary.feature_dictionary.data.domain.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false

)
