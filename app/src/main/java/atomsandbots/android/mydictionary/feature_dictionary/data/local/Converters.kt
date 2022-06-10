package atomsandbots.android.mydictionary.feature_dictionary.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import atomsandbots.android.mydictionary.feature_dictionary.data.domain.model.Meaning
import atomsandbots.android.mydictionary.feature_dictionary.data.util.JsonParser
import com.google.gson.reflect.TypeToken

//Converter class annotated with Provided Type Converters to parser my own converters
// for room to use my converter methods and not it's own

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromMeaningsJson(json: String): List<Meaning> {
        return jsonParser.fromJson<ArrayList<Meaning>>(
            json,
            object : TypeToken<ArrayList<Meaning>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toMeaningsJson(meanings: List<Meaning>): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<Meaning>>(){}.type
        ) ?: "[]"
    }
}