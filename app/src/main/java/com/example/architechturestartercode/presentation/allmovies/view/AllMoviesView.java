package com.example.architechturestartercode.presentation.allmovies.view;

import com.example.architechturestartercode.data.movies.model.Movie;

import java.util.List;

public interface AllMoviesView {
    void showLoading();

    void hideLoading();

    void toggleLoading(int visibility);

    void showMovies(List<Movie> movies);

    void showError(int errorMessage);
}
