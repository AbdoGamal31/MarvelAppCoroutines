package com.marvelapp.coroutines.marvelhome.data.localdatastore

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.marvelapp.coroutines.marvelhome.data.entities.Results

@Database(
    entities = [Results::class],
    version = 1
)
@TypeConverters(URlsDataConverter::class,ItemsDataConverter::class)
abstract class MarvelCharactersDB : RoomDatabase() {

    abstract fun marvelCharactersDao(): MarvelCharactersDao

    companion object {
        @Volatile
        private var instance: MarvelCharactersDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                MarvelCharactersDB::class.java,
                "MarvelCharactersDB.db"
            )
                .allowMainThreadQueries()
                .build()
    }
}