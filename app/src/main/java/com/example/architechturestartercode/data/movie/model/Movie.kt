package com.example.architechturestartercode.data.movie.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.architechturestartercode.network.Network
import com.google.gson.annotations.SerializedName


@Entity(tableName = "movies")
class Movie(
    @JvmField @field:PrimaryKey @field:SerializedName("id") var id: Long?,
    @JvmField @field:ColumnInfo(
        name = "title"
    ) @field:SerializedName("title") var title: String?,
    @JvmField @field:ColumnInfo(
        name = "language"
    ) @field:SerializedName("original_language") var language: String?,
    @field:ColumnInfo(
        name = "poster_path"
    ) @field:SerializedName("poster_path") private var poster: String,
    @JvmField @field:ColumnInfo(
        name = "overview"
    ) @field:SerializedName("overview") var overview: String?
) {
    fun getPoster(): String {
        return Network.Companion.IMAGE_BASE_URL + poster
    }

    fun setPoster(poster: String) {
        this.poster = poster
    }
}
