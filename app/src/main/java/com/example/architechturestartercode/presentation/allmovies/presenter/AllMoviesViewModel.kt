package com.example.architechturestartercode.presentation.allmovies.presenter

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.architechturestartercode.data.movie.MoviesRepositoryImp
import com.example.architechturestartercode.domin.moive.model.Movie
import com.example.architechturestartercode.domin.moive.usecase.GetAllMoviesUseCase
import com.example.architechturestartercode.presentation.allmovies.presenter.state.AllMoviesAction
import com.example.architechturestartercode.presentation.allmovies.presenter.state.AllMoviesEvent
import com.example.architechturestartercode.presentation.allmovies.presenter.state.AllMoviesScreenState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class AllMoviesViewModel(val app: Application) : AndroidViewModel(app) {

    private val getAllMoviesUseCase: GetAllMoviesUseCase =
        GetAllMoviesUseCase(MoviesRepositoryImp(app))

    var state by mutableStateOf(AllMoviesScreenState())
        private set

    private val _event = MutableSharedFlow<AllMoviesEvent>()
    val event: SharedFlow<AllMoviesEvent>
        get() = _event


    init {
        getAllMovies()
    }

    fun reduce(action: AllMoviesAction) {
        when (action) {
            is AllMoviesAction.AddToFav -> addToFav(action.movie)
            AllMoviesAction.Refresh -> getAllMovies()
        }

    }

    private fun getAllMovies() {
        viewModelScope.launch {
            try {
                state = state.copy(isLoading = true, error = null)
                val movies = getAllMoviesUseCase()
                state = state.copy(movies = movies, isLoading = false)
            } catch (ex: Exception) {
                state = state.copy(isLoading = false, error = ex.message)
            }
        }

    }

    private fun addToFav(Movie: Movie) {
        viewModelScope.launch {
//            moviesRepository.insertMovieToFav(Movie)
            _event.emit(AllMoviesEvent.ShowToast("Added to fav"))
        }
    }

}

