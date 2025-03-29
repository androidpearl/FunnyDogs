package com.pals.funnydogs.dogs

class DogUseCase(private val service: DogService) {

    suspend fun getDogApi() : Dog {
        val message = service.fetchDog()
        return message
    }
}