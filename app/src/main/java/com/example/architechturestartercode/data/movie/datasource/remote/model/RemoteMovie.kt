package com.example.architechturestartercode.data.movie.datasource.remote.model


import com.example.architechturestartercode.domin.movies.model.Movie
import com.google.gson.annotations.SerializedName

const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"

data class RemoteMovie(
    @SerializedName("id")

    var id: Long,

    @SerializedName("original_title")

    var title: String,

    @SerializedName("poster_path")

    var posterUrl: String,

    @SerializedName("original_language")

    var language: String,
) {
    val fullPosterUrl: String
        get() = IMAGE_BASE_URL + posterUrl
}

fun RemoteMovie.toMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        posterUrl = posterUrl,
        language = language
    )
}

fun List<RemoteMovie>.toMoviesList(): List<Movie> {
    return this.map { it.toMovie() }
}

