package atomsandbots.android.mydictionary.feature_dictionary.data.remote.dto

import atomsandbots.android.mydictionary.feature_dictionary.data.domain.model.Meaning

data class MeaningDto(
    val definitions: List<DefinitionDto>,
    val partOfSpeech: String
) {
    fun toMeaning(): Meaning {
        return Meaning(
            definition = definitions.map { it.toDefinition() },
            partOfSpeech = partOfSpeech
        )
    }
}