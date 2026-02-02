package com.example.architechturestartercode.model;

import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("id")
    private Long id;
    @SerializedName("title")
    private String title;
    @SerializedName("poster_path")
    private String posterUrl;
    @SerializedName("category")
    private String language;

    public Movie(Long id, String title, String posterUrl, String language) {
        this.id = id;
        this.title = title;
        this.posterUrl = posterUrl;
        this.language = language;
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

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
