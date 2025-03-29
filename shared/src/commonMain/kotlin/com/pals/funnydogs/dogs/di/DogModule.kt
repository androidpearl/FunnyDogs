package com.pals.funnydogs.dogs.di

import com.pals.funnydogs.dogs.DogService
import com.pals.funnydogs.dogs.DogUseCase
import com.pals.funnydogs.dogs.DogViewModel
import org.koin.dsl.module

val dogModule = module {
    single<DogService> {DogService(get())}
    single<DogUseCase> { DogUseCase(get()) }
    single<DogViewModel> {DogViewModel(get())}
}