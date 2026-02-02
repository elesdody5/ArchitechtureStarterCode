package com.example.architechturestartercode.data.movies.datasource.movies.remote;

import com.example.architechturestartercode.data.movies.model.Movie;

import java.util.List;

public interface MoviesNetworkResponse {
    void onSuccess(List<Movie> movies);
    void noInternet();
    void onFailure(String errorMessage);
}
