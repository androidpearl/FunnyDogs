package com.pals.funnydogs.dogs

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DogResponse (
    @SerialName("message")
    val message:String,
    @SerialName("status")
    val status:String
)