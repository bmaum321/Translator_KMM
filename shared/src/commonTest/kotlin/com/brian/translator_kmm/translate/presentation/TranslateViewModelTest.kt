package com.brian.translator_kmm.translate.presentation

import app.cash.turbine.test
import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import com.brian.translator_kmm.core.presentation.UiLanguage
import com.brian.translator_kmm.translate.data.local.FakeHistoryDataSource
import com.brian.translator_kmm.translate.data.remote.FakeTranslateClient
import com.brian.translator_kmm.translate.domain.history.HistoryItem
import com.brian.translator_kmm.translate.domain.translate.TranslateUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlin.test.BeforeTest
import kotlin.test.Test

class TranslateViewModelTest {

    // Can't use Junit in a KMM project because that is Android specific, need to use the kotlin test library

    private lateinit var viewModel: TranslateViewModel
    private lateinit var client: FakeTranslateClient
    private lateinit var historyDataSource: FakeHistoryDataSource

    @BeforeTest
    fun setup() {
        client = FakeTranslateClient()
        historyDataSource = FakeHistoryDataSource()

        viewModel = TranslateViewModel(
            translateUseCase = TranslateUseCase(
                client = client,
                historyDataSource = historyDataSource
            ),
            historyDataSource = historyDataSource,
            /**
             * We choose dispatchers default here because the Main dispatcher is not availble on JVM
             * unit tests
             */
            coroutineScope = CoroutineScope(Dispatchers.Default)
        )
    }

    /**
     * Check that our combine block in the viewmodel is working properly
     */
    @Test
    fun `State and history items are properly combined`() = runBlocking {
        viewModel.state.test {
            val initialState = awaitItem()
            assertThat(initialState).isEqualTo(TranslateState())

            val item = HistoryItem(
                id = 0,
                fromLanguageCode = "en",
                fromText = "from",
                toText = "to",
                toLanguageCode = "de"
            )

            /**
             * This will trigger the viewmodel's combine function because the history state flow has changed
             */
            historyDataSource.insertHistoryItem(item)
            
            val state = awaitItem()
            
            val expected = UiHistoryItem(
                id = item.id!!,
                fromText = item.fromText,
                toText = item.toText,
                fromLanguage = UiLanguage.byCode(item.fromLanguageCode),
                toLanguage = UiLanguage.byCode(item.toLanguageCode)
            )

            assertThat(state.history.first()).isEqualTo(expected)

        }
    }

    @Test
    fun `Translate success - state properly updated`() = runBlocking {
        viewModel.state.test {
            awaitItem()

            // Call await item again becasue we dont care about this state for this test, we want the next state
            viewModel.onEvent(TranslateEvent.ChangeTranslationText("test"))
            awaitItem()

            viewModel.onEvent(TranslateEvent.Translate)

            val loadingState = awaitItem()
            assertThat(loadingState.isTranslating).isTrue()

            val resultState = awaitItem()
            assertThat(resultState.isTranslating).isFalse()
            assertThat(resultState.toText).isEqualTo(client.translatedText)
        }
    }
}