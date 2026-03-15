package com.example.architechturestartercode.di

import com.example.architechturestartercode.data.movie.datasource.local.IMoviesLocalDataSource
import com.example.architechturestartercode.data.movie.datasource.local.MoviesLocalDataSource
import com.example.architechturestartercode.data.movie.datasource.remote.IMoviesRemoteDataSource
import com.example.architechturestartercode.data.movie.datasource.remote.MoviesRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun bindRemoteDataSource(remoteDataSource: MoviesRemoteDataSource): IMoviesRemoteDataSource

    @Binds
    fun bindLocalDataSource(localDataSource: MoviesLocalDataSource): IMoviesLocalDataSource
}