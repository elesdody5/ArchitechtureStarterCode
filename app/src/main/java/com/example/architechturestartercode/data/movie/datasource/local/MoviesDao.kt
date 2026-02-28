package com.example.architechturestartercode.data.movie.datasource.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.architechturestartercode.data.movie.model.Movie

@Dao
interface MoviesDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertMovies(movie: Movie)

    @Delete
    fun deleteMovies(movie: Movie)

    @Query("SELECT * FROM movies")
    fun getAllMovies(): LiveData<List<Movie>>
}

