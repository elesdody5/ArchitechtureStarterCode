package com.example.architechturestartercode.presentation.favmovies.presenter;

import androidx.lifecycle.LiveData;

import com.example.architechturestartercode.data.movie.model.Movie;

import java.util.List;

public interface FavPresenter {
    LiveData<List<Movie>> getFavMovies();
    void deleteFavMovie(Movie movie);
}
