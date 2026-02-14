package com.example.architechturestartercode.data.movie.datasource.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.architechturestartercode.data.movie.model.Movie;

import java.util.List;

@Dao
public interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMovie(Movie movie);

    @Query("SELECT * FROM movies")
    LiveData<List<Movie>> getMovies();

    @Delete
    void  deleteMovie(Movie movie);
}
