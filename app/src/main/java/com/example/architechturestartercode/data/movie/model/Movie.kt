package com.example.architechturestartercode.data.movie.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.architechturestartercode.data.network.Network
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies")
data class Movie(
    @SerializedName("id")
    @ColumnInfo(name = "id")
    @PrimaryKey
    var id: Long,

    @SerializedName("original_title")
    @ColumnInfo(name = "title")
    var title: String,

    @SerializedName("poster_path")
    @ColumnInfo(name = "poster_url")
    var posterUrl: String,

    @SerializedName("original_language")
    @ColumnInfo(name = "language")
    var language: String
) {
    val fullPosterUrl: String
        get() = Network.IMAGE_BASE_URL + posterUrl
}

