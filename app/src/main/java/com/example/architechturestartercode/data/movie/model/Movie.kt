package com.example.architechturestartercode.data.movie.model;


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
    @SerializedName("title")
    @ColumnInfo(name = "title")
    private String title;
    @SerializedName("poster_path")
    @ColumnInfo(name = "poster_path")
    private String poster;
    @SerializedName("overview")
    @ColumnInfo(name = "overview")
    private String overview;
    @SerializedName("original_language")
    @ColumnInfo(name = "language")
    private String language;

    public Movie(Long id, String title, String language, String poster, String overview) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.overview = overview;
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


    public String getPoster() {
        return Network.IMAGE_BASE_URL + poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
