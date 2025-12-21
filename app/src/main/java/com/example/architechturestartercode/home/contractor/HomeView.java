package com.example.architechturestartercode.home.contractor;

import com.example.architechturestartercode.model.movie.Movie;

import java.util.List;

public interface HomeView {
    public void setProgressVisibility(int visibility);

    public void setErrorMessage(int visibility, String message);

    public void setMoviesList(List<Movie> movies);

    public void navigateToMovieDetails(Long movieId);
}
