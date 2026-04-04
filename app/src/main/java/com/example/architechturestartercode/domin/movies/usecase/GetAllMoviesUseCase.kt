package com.example.architechturestartercode.domin.movies.usecase

import com.example.architechturestartercode.domin.movies.model.Movie
import com.example.architechturestartercode.domin.movies.repo.IMoviesRepository

class GetAllMoviesUseCase(private val moviesRepository: IMoviesRepository) {
    suspend operator fun invoke(): Result<List<Movie>> {
        return  moviesRepository.getAllMovies()
    }

}