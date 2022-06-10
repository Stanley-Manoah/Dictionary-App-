package atomsandbots.android.mydictionary.feature_dictionary.data.remote.dto

import atomsandbots.android.mydictionary.feature_dictionary.data.domain.model.Definition

data class DefinitionDto(
    val antonyms: List<String>,
    val definition: String,
    //Json object is not returning example as an object delete after finishing the projech
    // and build again.
    val example: String?,
    val synonyms: List<Any>
){
    fun toDefinition(): Definition{
        return Definition(
            antonyms = antonyms,
            definition = definition,
            example = example,
            synonyms = synonyms
        )
    }
}