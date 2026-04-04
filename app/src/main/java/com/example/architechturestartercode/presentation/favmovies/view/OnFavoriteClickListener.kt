package com.example.architechturestartercode.presentation.favmovies.view

import com.example.architechturestartercode.data.movie.datasource.remote.model.RemoteMovie

interface OnFavoriteClickListener {
    fun deleteFromFav(remoteMovie: RemoteMovie)
}

