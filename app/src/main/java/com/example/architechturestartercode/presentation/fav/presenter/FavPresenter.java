package com.example.architechturestartercode.presentation.fav.presenter;

import androidx.lifecycle.LiveData;

import com.example.architechturestartercode.data.movies.model.Movie;

import java.util.List;

public interface FavPresenter {
    LiveData<List<Movie>> getFavMovies();

    void deleteFromFav(Movie movie);
}
