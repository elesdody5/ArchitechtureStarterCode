package com.example.architechturestartercode.network.moviedatasource;

import com.example.architechturestartercode.model.movie.Movie;
import com.example.architechturestartercode.model.movie.MoviesResponse;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieService {
    @GET("movie/popular?api_key=71ddca1effa9f38a5f61afe803adb266")
    Call<MoviesResponse> getMovies();

    @GET("movie/{movieId}?api_key=71ddca1effa9f38a5f61afe803adb266")
    Call<Movie> getMovieById(@Path("movieId") Long movieId);

}
