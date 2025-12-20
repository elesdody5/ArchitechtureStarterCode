package com.example.architechturestartercode.network.moviedatasource;

import com.example.architechturestartercode.model.movie.Movie;

public interface MovieByIdResponse {
    void onSuccess(Movie movie);
    void onFailure(String message);
    void onNoNetwork();
    void onTimeOut();
}
