package com.pals.funnydogs.android

import android.app.Application
import com.pals.funnydogs.android.di.viewModelModule
import com.pals.funnydogs.di.sharedKoinModule
import org.koin.core.context.startKoin

class DogApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initCoin()
    }

    private fun initCoin() {
        val modules = sharedKoinModule + viewModelModule

        startKoin {
            applicationContext
            modules(modules)
        }
    }
}