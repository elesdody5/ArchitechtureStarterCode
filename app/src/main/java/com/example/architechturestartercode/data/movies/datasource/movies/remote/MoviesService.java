package com.example.architechturestartercode.data.movies.datasource.movies.remote;

import com.example.architechturestartercode.data.movies.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesService {
    @GET("discover/movie?api_key=71ddca1effa9f38a5f61afe803adb266")
    Call<MoviesResponse> getMovies();
}
