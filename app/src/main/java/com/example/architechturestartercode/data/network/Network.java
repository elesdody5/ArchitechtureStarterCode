package com.example.architechturestartercode.data.network;

import com.example.architechturestartercode.data.movies.datasource.movies.remote.MoviesService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {
    private MoviesService moviesService;
    private Retrofit retrofit;
    public static String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500";

    public Network() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")// Replace with actual base URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public MoviesService getMoviesService() {
        if (moviesService == null) {
            moviesService = retrofit.create(MoviesService.class);
        }
        return moviesService;
    }


}
