package com.example.architechturestartercode.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.architechturestartercode.data.movie.datasource.local.MoviesDao
import com.example.architechturestartercode.data.movie.model.RemoteMovieResponse

@Database(entities = [RemoteMovieResponse::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "movies_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

