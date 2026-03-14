package com.example.architechturestartercode.di

import android.app.Application
import com.example.architechturestartercode.data.db.AppDatabase
import com.example.architechturestartercode.data.movie.MoviesRepository
import com.example.architechturestartercode.data.movie.datasource.local.MoviesDao
import com.example.architechturestartercode.data.movie.datasource.local.MoviesLocalDataSource
import com.example.architechturestartercode.data.movie.datasource.remote.MoviesRemoteDataSource
import com.example.architechturestartercode.data.movie.datasource.remote.MoviesService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer(private val application: Application) {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val moviesService: MoviesService by lazy { retrofit.create(MoviesService::class.java) }
    private val moviesDao: MoviesDao by lazy { AppDatabase.getInstance(application).moviesDao() }
    private val localDataSource by lazy { MoviesLocalDataSource(moviesDao) }
    private val remoteDataSource by lazy { MoviesRemoteDataSource(moviesService) }
    val moviesRepository by lazy { MoviesRepository(remoteDataSource, localDataSource) }


}