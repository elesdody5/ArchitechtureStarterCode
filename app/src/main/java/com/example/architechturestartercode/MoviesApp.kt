package com.example.architechturestartercode

import android.app.Application
import com.example.architechturestartercode.di.AppContainer

class MoviesApp : Application() {
    lateinit var appContainer: AppContainer
        private set

    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer(this)
    }
}