package com.example.architechturestartercode.presentation.allmovies.view

import com.example.architechturestartercode.data.movie.model.Movie

interface OnMovieClicked {
    fun addToFav(movie: Movie)
}

