package com.pals.funnydogs.di

import com.pals.funnydogs.dogs.DogViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin(){
    val modules = sharedKoinModule

    startKoin {
        modules(modules)
    }
}

class DogInjector : KoinComponent {
    val dogViewModel: DogViewModel by inject()
}