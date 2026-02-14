package com.example.architechturestartercode.data.movie.model

import com.google.gson.annotations.SerializedName

class MoviesResponse(@field:SerializedName("results") var results: MutableList<Movie>?)
