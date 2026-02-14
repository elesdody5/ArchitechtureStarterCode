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
    @Insert(onConflict = OnConflictStrategy.Companion.IGNORE)
    suspend fun insertMovie(movie: Movie)

    @get:Query("SELECT * FROM movies")
    val movies: LiveData<MutableList<Movie>>

    @Delete
    suspend fun deleteMovie(movie: Movie)
}
