package com.example.architechturestartercode.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.architechturestartercode.data.movie.datasource.local.MoviesDao
import com.example.architechturestartercode.data.movie.datasource.remote.model.RemoteMovie

@Database(entities = [RemoteMovie::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
}

