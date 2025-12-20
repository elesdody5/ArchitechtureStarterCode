package com.example.architechturestartercode.network.moviedatasource;

import com.example.architechturestartercode.model.movie.Movie;

import java.util.List;

public interface MovieResponseCallback {
    void onSuccess(List<Movie> movies);
    void onFailure(String message);
    void onNoNetwork();
    void onTimeOut();
}

