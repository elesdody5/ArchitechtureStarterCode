package com.example.architechturestartercode.data.movies.datasource.movies.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.architechturestartercode.data.movies.model.Movie;

import java.util.List;

@Dao
public interface MoviesDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    void addToFav(Movie movie);

    @Delete
    void deleteFromFav(Movie movie);

    @Query("SELECT * FROM movies")
    LiveData<List<Movie>> getMovies();
}
