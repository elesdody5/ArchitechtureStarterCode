package com.example.architechturestartercode.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.architechturestartercode.network.Network;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "movies")
public class Movie {
    @SerializedName("id")
    @PrimaryKey
    private Long id;
    @SerializedName("original_title")
    @ColumnInfo(name = "title")
    private String title;
    @SerializedName("original_language")
    @ColumnInfo(name = "language")
    private String language;
    @SerializedName("poster_path")
    @ColumnInfo(name = "poster_url")
    private String posterUrl;

    public Movie(Long id, String title, String language, String posterUrl) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.posterUrl = posterUrl;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPosterUrl() {
        return Network.IMAGE_BASE_URL + posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }
}
