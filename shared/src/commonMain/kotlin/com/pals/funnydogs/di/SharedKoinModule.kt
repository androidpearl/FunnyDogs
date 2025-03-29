package com.pals.funnydogs.di

import com.pals.funnydogs.dogs.di.dogModule

val sharedKoinModule = listOf(
    dogModule,
    networkModule
)