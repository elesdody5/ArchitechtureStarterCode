package com.example.architechturestartercode.data.movie.datasource.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.architechturestartercode.data.movie.datasource.local.model.LocalMovie
import com.example.architechturestartercode.data.movie.datasource.remote.model.RemoteMovie

@Dao
interface MoviesDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertMovies(localMovie: LocalMovie)

    @Delete
    suspend fun deleteMovies(localMovie: LocalMovie)

    @Query("SELECT * FROM movies")
    fun getAllMovies(): LiveData<List<LocalMovie>>
}

