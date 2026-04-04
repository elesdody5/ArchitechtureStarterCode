package com.example.architechturestartercode.data.movie.datasource.remote.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    val results: List<RemoteMovie>
)

