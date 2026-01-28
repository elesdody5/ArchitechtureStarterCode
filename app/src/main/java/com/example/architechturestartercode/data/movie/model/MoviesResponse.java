package com.example.architechturestartercode.data.movie.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesResponse {
    @SerializedName("results")
    public List<Movie> results;
    public MoviesResponse(List<Movie> results) {
        this.results = results;
    }

}
