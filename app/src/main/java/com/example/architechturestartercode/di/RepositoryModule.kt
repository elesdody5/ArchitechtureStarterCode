package com.example.architechturestartercode.di

import com.example.architechturestartercode.data.movie.IMoviesRepository
import com.example.architechturestartercode.data.movie.MoviesRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(repositoryImp: MoviesRepositoryImp): IMoviesRepository
}