package com.example.architechturestartercode.domin.moive.usecase


import com.example.architechturestartercode.domin.moive.model.Movie
import com.example.architechturestartercode.domin.moive.repository.MoviesRepository

class GetAllMoviesUseCase(private val moviesRepository: MoviesRepository) {
    suspend operator fun invoke(): List<Movie> = moviesRepository.getAllMovies()
}