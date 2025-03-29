package com.pals.funnydogs.dogs

data class DogState (
    val dog: Dog = Dog("","success"),
    val loading: Boolean = false,
    val error:String? = null
)