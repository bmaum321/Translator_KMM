package com.brian.translator_kmm.translate.domain.translate

import com.brian.translator_kmm.core.domain.language.Language
import com.brian.translator_kmm.core.domain.util.Resource
import com.brian.translator_kmm.translate.domain.history.HistoryDataSource
import com.brian.translator_kmm.translate.domain.history.HistoryItem


/**
 * This usecase is a single piece of business logic, which makes it easy to unit test
 */
class TranslateUseCase(
    private val client: TranslateClient,
    private val historyDataSource: HistoryDataSource
) {

    suspend fun execute(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): Resource<String> {
        return try {
            val translatedText = client.translate(
                fromLanguage = fromLanguage,
                fromText = fromText,
                toLanguage = toLanguage
            )
            /**
             * Update the database with translated text to record history
             */
            historyDataSource.insertHistoryItem(HistoryItem(
                id = null,
                fromLanguageCode = fromLanguage.langCode,
                fromText = fromText,
                toLanguageCode = toLanguage.langCode,
                toText = translatedText
            ))
            Resource.Success(translatedText)
        } catch (e: TranslateException) {
            e.printStackTrace()
            Resource.Error(e)
        }
    }
}