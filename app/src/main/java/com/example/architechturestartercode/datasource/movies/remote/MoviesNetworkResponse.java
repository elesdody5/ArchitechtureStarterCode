package com.example.architechturestartercode.datasource.movies.remote;

import com.example.architechturestartercode.model.Movie;

import java.util.List;

public interface MoviesNetworkResponse {
    void onSuccess(List<Movie> movies);
    void noInternet();
    void onFailure(String errorMessage);
}
