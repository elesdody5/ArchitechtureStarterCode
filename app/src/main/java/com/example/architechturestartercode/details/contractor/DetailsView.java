package com.example.architechturestartercode.details.contractor;

import com.example.architechturestartercode.model.movie.Movie;

public interface DetailsView {
    void setProgressVisibility(int visibility);

    void setErrorMessage(int visibility, String message);

    void displayMovieDetails(Movie movie);
}

