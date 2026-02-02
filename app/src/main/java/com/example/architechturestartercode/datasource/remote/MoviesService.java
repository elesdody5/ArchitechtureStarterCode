package com.example.architechturestartercode.datasource.remote;

import com.example.architechturestartercode.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesService {
    @GET("discover/movie?api_key=71ddca1effa9f38a5f61afe803adb266")
    Call<MovieResponse> getMovies();

}
