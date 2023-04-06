package com.bignerdranch.android.courseproject.data.local

import android.content.Context
import androidx.room.*
import com.bignerdranch.android.courseproject.data.entities.Locations
import com.bignerdranch.android.courseproject.data.entities.TypeConverter

@TypeConverters(value = [TypeConverter::class])
@Database(entities = [Locations::class], version = 5, exportSchema = false)
abstract class LocationsDatabase : RoomDatabase() {

    abstract fun getLocationsDao(): LocationsDao

    companion object {
        @Volatile private var instance: LocationsDatabase? = null

        fun getDatabase(context: Context): LocationsDatabase =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, LocationsDatabase::class.java, "locations")
                .fallbackToDestructiveMigration()
                .build()
    }
}