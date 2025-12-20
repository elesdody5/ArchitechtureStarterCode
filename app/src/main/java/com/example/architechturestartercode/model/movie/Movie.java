package com.example.architechturestartercode.model.movie;

import com.example.architechturestartercode.network.Network;
import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("id")
    private Long id;
    @SerializedName("title")
    private String title;
    @SerializedName("poster_path")
    private String imageUrl;
    @SerializedName("overview")
    private String overview;
    @SerializedName("vote_average")
    private Double rating;

    public Movie(Long id, String title, String imageUrl, String overview, Double rating) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.overview = overview;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return Network.Image_Base_URL + imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
