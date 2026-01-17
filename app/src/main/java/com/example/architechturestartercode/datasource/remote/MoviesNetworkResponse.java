package com.example.architechturestartercode.datasource.remote;

import com.example.architechturestartercode.model.Movie;

import java.util.List;

public interface MoviesNetworkResponse {
    void onSuccess(List<Movie> movies);
    void onError(String errorMessage);
    void serverError(String serverErrorMessage);
}
