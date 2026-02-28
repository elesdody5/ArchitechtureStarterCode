package com.example.architechturestartercode.presentation.favmovies.view

import com.example.architechturestartercode.data.movie.model.Movie

interface OnFavoriteClickListener {
    fun deleteFromFav(movie: Movie)
}

