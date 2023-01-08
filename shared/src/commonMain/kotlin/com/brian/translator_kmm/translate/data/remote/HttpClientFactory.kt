package com.brian.translator_kmm.translate.data.remote

import io.ktor.client.*


/**
 * expect is a keyword for KMM projects, similar to abstract
 * We expect this class to have an implementation in all other source packages
 */
expect class HttpClientFactory {
    fun create(): HttpClient
}