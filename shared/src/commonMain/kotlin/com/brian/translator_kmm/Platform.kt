package com.brian.translator_kmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform