package com.example.architechturestartercode.presentation.allmovies.presenter;

import com.example.architechturestartercode.data.movie.model.Movie;

public interface AllMoviesPresenter {
    void getAllMovies();
    void addToFav(Movie movie);

    void openMovieDetails(Movie movie);
}
