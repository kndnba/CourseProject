package com.bignerdranch.android.courseproject.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bignerdranch.android.courseproject.data.entities.Character
import com.bignerdranch.android.courseproject.data.entities.ListCharacters

@Dao
interface EpisodesDetailsDao {
    @Query("SELECT * FROM characters WHERE id IN (:ids)")
    fun getMultipleCharacters(ids: List<Int>) : LiveData<ListCharacters>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(episodes: List<Character>)
}