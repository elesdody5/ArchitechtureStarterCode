package com.example.architechturestartercode.presentation.allmovies.view;

import com.example.architechturestartercode.data.movie.model.Movie;

import java.util.List;

public interface AllMoviesView {
    void showLoading();
    void hideLoading();
    void setMovies(List<Movie> movies);
    void showError(String errorMessage);
    void onAddToFavSuccess();

    void navigateToDetails(Movie movie);
}
