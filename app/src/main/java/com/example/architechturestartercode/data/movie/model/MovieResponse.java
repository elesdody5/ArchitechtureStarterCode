package com.example.architechturestartercode.data.movie.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {
    @SerializedName("results")
    public List<Movie> results;

    public MovieResponse(List<Movie> results) {
        this.results = results;
    }

}
