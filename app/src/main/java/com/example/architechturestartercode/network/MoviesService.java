package com.example.architechturestartercode.network;

import com.example.architechturestartercode.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface MoviesService {
    @GET("products")
    Call<MovieResponse> getAllMovies();
}
