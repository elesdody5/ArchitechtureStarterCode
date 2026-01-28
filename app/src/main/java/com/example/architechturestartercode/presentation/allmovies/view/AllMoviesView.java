package com.example.architechturestartercode.presentation.allmovies.view;

import com.example.architechturestartercode.data.movie.model.Movie;

import java.util.List;

public interface AllMoviesView {
    void onMoviesFetchSuccess(List<Movie> movies);
    void onMoviesFetchError(String errorMessage);
}
