package com.bignerdranch.android.courseproject.data.local

import android.content.Context
import androidx.room.*
import com.bignerdranch.android.courseproject.data.entities.Episodes
import com.bignerdranch.android.courseproject.data.entities.TypeConverter

@Database(entities = [Episodes::class], version = 10, exportSchema = false)
abstract class EpisodesDatabase : RoomDatabase() {

    abstract fun getEpisodesDao(): EpisodesDao

    companion object {
        @Volatile private var instance: EpisodesDatabase? = null

        fun getDatabase(context: Context): EpisodesDatabase =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, EpisodesDatabase::class.java, "episodes")
                .fallbackToDestructiveMigration()
                .build()
    }
}