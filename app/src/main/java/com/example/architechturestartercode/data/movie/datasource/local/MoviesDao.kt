package com.example.architechturestartercode.data.movie.datasource.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.architechturestartercode.data.movie.model.RemoteMovieResponse

@Dao
interface MoviesDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertMovies(remoteMovieResponse: RemoteMovieResponse)

    @Delete
    suspend fun deleteMovies(remoteMovieResponse: RemoteMovieResponse)

    @Query("SELECT * FROM movies")
    fun getAllMovies(): LiveData<List<RemoteMovieResponse>>
}

