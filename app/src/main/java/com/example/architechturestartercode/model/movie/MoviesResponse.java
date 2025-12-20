package com.example.architechturestartercode.model.movie;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesResponse {
    @SerializedName("results")
    public  List<Movie> results;
}
