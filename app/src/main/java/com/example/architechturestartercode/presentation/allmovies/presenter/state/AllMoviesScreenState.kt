package com.example.architechturestartercode.presentation.allmovies.presenter.state

import com.example.architechturestartercode.domin.moive.model.Movie

data class AllMoviesScreenState(
    val movies: List<Movie> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)

sealed interface AllMoviesAction {
    data class AddToFav(val movie: Movie) : AllMoviesAction
    data object Refresh : AllMoviesAction
}

sealed interface AllMoviesEvent {
    data class ShowToast(val message: String) : AllMoviesEvent
}