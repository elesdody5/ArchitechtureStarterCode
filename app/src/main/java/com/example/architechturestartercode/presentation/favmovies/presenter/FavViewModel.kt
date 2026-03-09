package com.example.architechturestartercode.presentation.favmovies.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.architechturestartercode.data.movie.MoviesRepositoryImp
import com.example.architechturestartercode.data.movie.model.RemoteMovieResponse
import com.example.architechturestartercode.domin.moive.model.Movie
import kotlinx.coroutines.launch

class FavViewModel(private val moviesRepository: MoviesRepositoryImp) : ViewModel() {

    val deletedSuccess = MutableLiveData<Boolean>()
    fun getFavMovies(): LiveData<List<Movie>> {
        return moviesRepository.getAllFavMovies()
    }

    fun deleteFavMovie(movie: Movie) {
        viewModelScope.launch {
            moviesRepository.deleteMovieFromFav(movie)
            deletedSuccess.value = true
        }
    }
}

class FavViewModelFactory(
    private val moviesRepository: MoviesRepositoryImp,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FavViewModel(moviesRepository) as T
    }
}
