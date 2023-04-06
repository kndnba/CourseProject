package com.bignerdranch.android.courseproject.data.entities

import androidx.room.TypeConverter
import com.google.gson.Gson

class TypeConverter {

    @TypeConverter
    fun fromCharactersToJSON(characterList: ListCharacters?): String? {
        return Gson().toJson(characterList)
    }

    @TypeConverter
    fun fromJSONToCharacters(json: String?): ListCharacters? {
        return Gson().fromJson(json, ListCharacters::class.java)
    }
}