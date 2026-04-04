package com.example.architechturestartercode.data.movie.datasource.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.architechturestartercode.data.movie.datasource.remote.model.IMAGE_BASE_URL
import com.example.architechturestartercode.domin.movies.model.Movie

@Entity(tableName = "movies")
data class LocalMovie(
    @ColumnInfo(name = "id")
    @PrimaryKey
    var id: Long,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "poster_url")
    var posterUrl: String,

    @ColumnInfo(name = "language")
    var language: String,
) {
    val fullPosterUrl: String
        get() = IMAGE_BASE_URL + posterUrl
}

fun Movie.toLocalMovie(): LocalMovie {
    return LocalMovie(
        id = this.id,
        title = this.title,
        posterUrl = this.posterUrl,
        language = this.language
    )
}

fun LocalMovie.toDomainMovie(): Movie {
    return Movie(
        id = this.id,
        title = this.title,
        posterUrl = this.posterUrl,
        language = this.language
    )
}