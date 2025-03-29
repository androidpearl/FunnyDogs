package com.pals.funnydogs

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform