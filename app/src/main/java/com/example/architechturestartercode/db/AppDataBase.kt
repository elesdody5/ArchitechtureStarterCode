package com.example.architechturestartercode.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.example.architechturestartercode.data.movie.datasource.local.MoviesDao
import com.example.architechturestartercode.data.movie.model.Movie

@Database(entities = [Movie::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao?

    companion object {
        private var instance: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDataBase::class.java,
                    "moviesdb"
                ).build()
            }
            return instance!!
        }
    }
}
