package com.pals.funnydogs.dogs

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class DogService(
    private val httpClient: HttpClient
) {

    suspend fun fetchDog() : Dog {
        val response : DogResponse =
            httpClient.get("https://dog.ceo/api/breeds/image/random").body()
        return Dog(response.message, response.status)
    }
}