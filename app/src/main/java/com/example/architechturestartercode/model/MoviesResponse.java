package com.example.architechturestartercode.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesResponse {
    @SerializedName("results")
    private List<Movie> results;

    public MoviesResponse(List<Movie> results) {
        this.results = results;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
}
