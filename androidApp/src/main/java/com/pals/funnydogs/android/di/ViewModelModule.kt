package com.pals.funnydogs.android.di

import com.pals.funnydogs.dogs.DogViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        DogViewModel(get())
    }
}