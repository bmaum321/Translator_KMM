package com.brian.translator_kmm.translate.domain.translate

import com.brian.translator_kmm.core.domain.language.Language

/**
 * We abstract the client with an interface in case we want to change the logic down the road.
 * We rely on abstractions not concretions. Also allows us to easily inject fakes for testing
 */
interface TranslateClient {
    suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): String
}