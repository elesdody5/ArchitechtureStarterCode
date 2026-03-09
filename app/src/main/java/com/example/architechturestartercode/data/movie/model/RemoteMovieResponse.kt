package com.example.architechturestartercode.data.movie.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.architechturestartercode.data.network.Network
import com.example.architechturestartercode.domin.moive.model.Movie
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies")
data class RemoteMovieResponse(
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
    var language: String,
) {
    val fullPosterUrl: String
        get() = Network.IMAGE_BASE_URL + posterUrl
}

fun RemoteMovieResponse.toDomain(): Movie {
    return Movie(
        id = id,
        title = title,
        posterUrl = fullPosterUrl,
        language = language
    )
}

fun Movie.toData(): RemoteMovieResponse {
    return RemoteMovieResponse(
        id = id,
        title = title,
        posterUrl = posterUrl,
        language = language
    )
}

fun List<RemoteMovieResponse>.toDomainList(): List<Movie> {
    return this.map { it.toDomain() }
}

