package com.brian.translator_kmm.translate.data.translate

import com.brian.translator_kmm.NetworkConstants
import com.brian.translator_kmm.core.domain.language.Language
import com.brian.translator_kmm.translate.domain.translate.TranslateClient
import com.brian.translator_kmm.translate.domain.translate.TranslateError
import com.brian.translator_kmm.translate.domain.translate.TranslateException
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.util.network.*
import io.ktor.utils.io.errors.*

/**
 * The client we use here will differ on IOS and Android,  the instantiation logic is a little
 * different, but this core logic will be the same for both.
 * Android uses Android Client
 * IOS uses Darwin client
 *
 * We are using LibreTranslate, which is a free, open source, self hosted API
 *
 * Here we posting Json data to the API url. The Api will then translate the text and send a Json
 * object back to the client
 */
class KtorTranslateClient(
    private val httpClient: HttpClient
): TranslateClient {

    override suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): String {
        val result = try {
            httpClient.post {
                url(NetworkConstants.BASE_URL + "/translate")
                contentType(ContentType.Application.Json)
                setBody(
                    TranslateDto(
                        textToTranslate = fromText,
                        sourceLanguageCode = fromLanguage.langCode,
                        targetLanguageCode = toLanguage.langCode
                    )
                )
            }

        } catch (e: IOException) {
            throw TranslateException(TranslateError.SERVICE_UNAVAILABLE)
        }

        when(result.status.value) {
            in 200..299 -> Unit
            500 -> throw TranslateException(TranslateError.SERVER_ERROR)
            in 400..499 -> throw  TranslateException(TranslateError.CLIENT_ERROR)
            else -> throw TranslateException(TranslateError.UNKNOWN_ERROR)
        }

        return try {
            result.body<TranslatedDto>().translatedText
        } catch (e: Exception) {
            throw TranslateException(TranslateError.SERVER_ERROR)
        }
    }
}