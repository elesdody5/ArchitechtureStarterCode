package com.example.architechturestartercode.data.movie.datasource.remote;

import com.example.architechturestartercode.data.movie.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieService {
    @GET("discover/movie?api_key=71ddca1effa9f38a5f61afe803adb266")
    Call<MoviesResponse> getMovies();

}
