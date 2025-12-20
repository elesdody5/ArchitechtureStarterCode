package com.example.architechturestartercode.network;

import com.example.architechturestartercode.network.moviedatasource.MovieService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {
    private static String Base_URL = "https://api.themoviedb.org/3/";
    public static String Image_Base_URL = "https://image.tmdb.org/t/p/w500";
    public static Network instance;
    private Network(){}

    public static Network getInstance() {
        if (instance == null) {
            instance = new Network();
        }
        return instance;
    }

    public MovieService getMovieService() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Base_URL)
                .build();

        return retrofit.create(MovieService.class);
    }
}
