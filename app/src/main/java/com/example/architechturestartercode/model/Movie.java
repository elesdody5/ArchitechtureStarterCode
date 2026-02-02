package com.example.architechturestartercode.model;

import static com.example.architechturestartercode.network.Network.IMAGE_BASE_URL;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "movies")
public class Movie {
    @SerializedName("id")
    @ColumnInfo(name = "id")
    @PrimaryKey
    private Long id;
    @SerializedName("original_title")
    @ColumnInfo(name = "title")
    private String title;
    @SerializedName("poster_path")
    @ColumnInfo(name = "poster_url")
    private String posterUrl;
    @SerializedName("original_language")
    @ColumnInfo(name = "language")
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
        return IMAGE_BASE_URL + posterUrl;
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
