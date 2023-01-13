package com.brian.translator_kmm.translate.presentation

import com.brian.translator_kmm.core.domain.util.Resource
import com.brian.translator_kmm.core.domain.util.toCommonStateFlow
import com.brian.translator_kmm.core.presentation.UiLanguage
import com.brian.translator_kmm.translate.domain.history.HistoryDataSource
import com.brian.translator_kmm.translate.domain.translate.TranslateException
import com.brian.translator_kmm.translate.domain.translate.TranslateUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.updateAndGet
import kotlinx.coroutines.launch


/**
 * We want to implement this so we can share this viewmodel between IOS and Android
 *
 * In the end we will have a wrapper viewmodel class in IOS and android
 */
class TranslateViewModel(
    private val translateUseCase: TranslateUseCase,
    private val historyDataSource: HistoryDataSource,
    private val coroutineScope: CoroutineScope?
) {
    private val viewModelScope = coroutineScope ?: CoroutineScope(Dispatchers.Main)

    private val _state = MutableStateFlow(TranslateState())

    /**
     * We need our history state in our state flow, to do this we will combine the history that is
     * exposed as a flow from the database with the translate state
     *
     * When either of these flows emits a value, the below block will be called and create a new flow
     * using the transform function
     */
    val state = combine(
        _state,
        historyDataSource.getHistory()
    ) { state, history ->
        if(state.history != history) {
            state.copy(
                history = history.mapNotNull { item ->
                    UiHistoryItem(
                        id = item.id ?: return@mapNotNull null,
                        fromText = item.fromText,
                        toText = item.toText,
                        toLanguage = UiLanguage.byCode(item.toLanguageCode),
                        fromLanguage = UiLanguage.byCode(item.fromLanguageCode)
                    )
                }
            )
        } else state
        /**
         * The flow combiner will execute as long as there is an active subscriber, if all subscribers
         * disappear it will execute 5 more seconds.
         *
         * We also want to make sure to expose the state flow using our common state flow function
         */
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), TranslateState())
        .toCommonStateFlow()

    private var translateJob: Job? = null

    fun onEvent(event: TranslateEvent) {
        when(event) {
            is TranslateEvent.ClearTranslateHistory -> {
                viewModelScope.launch {
                    historyDataSource.clearHistory()
                }
            }
            is TranslateEvent.ChangeTranslationText -> {
                _state.update { it.copy(
                    fromText = event.text
                ) }
            }
            is TranslateEvent.ChooseFromLanguage -> {
                _state.update { it.copy(
                    isChoosingFromLanguage = false,
                    fromLanguage = event.language
                ) }
            }
            /**
             * If the user selects a new to language we want to automatically translate that text
             * so we call translate after getting the new state
             */
            is TranslateEvent.ChooseToLanguage -> {
                val newState = _state.updateAndGet { it.copy(
                    isChoosingToLanguage = false,
                    toLanguage = event.language
                ) }
                translate(newState)
            }
            TranslateEvent.EditTranslation -> {
                if(state.value.toText != null) {
                    _state.update { it.copy(
                        toText = null,
                        isTranslating = false
                    ) }
                }
            }
            TranslateEvent.OnErrorScreen -> {
                _state.update { it.copy(
                    error = null
                ) }
            }
            is TranslateEvent.SelectHistoryItem -> {
                /**
                 * If the user selects a history item, we want to cancel the current translate job
                 */
                translateJob?.cancel()
                _state.update { it.copy(
                    fromText = event.item.fromText,
                    toText = event.item.toText,
                    isTranslating = false,
                    fromLanguage = event.item.fromLanguage,
                    toLanguage = event.item.toLanguage
                ) }

            }
            TranslateEvent.StopChoosingLanguage -> {
                _state.update { it.copy(
                    isChoosingToLanguage = false,
                    isChoosingFromLanguage = false
                ) }
            }
            is TranslateEvent.SubmitVoiceResult -> {
                _state.update { it.copy(
                    fromText = event.result ?: it.fromText,
                    isTranslating = if(event.result != null) false else it.isTranslating,
                    toText = if(event.result != null) null else it.toText
                ) }
            }
            TranslateEvent.SwapLanguages -> {
                _state.update { it.copy(
                    toLanguage = it.fromLanguage,
                    fromLanguage = it.toLanguage,
                    fromText = it.toText ?: "",
                    toText = if(it.toText != null) it.fromText else null
                ) }
            }
            TranslateEvent.Translate -> translate(state.value)
            TranslateEvent.CloseTranslation -> {
                _state.update { it.copy(
                    isTranslating = false,
                    fromText = "",
                    toText = null
                ) }
            }
            TranslateEvent.OpenFromLanguageDropDown -> {
                _state.update { it.copy(
                    isChoosingFromLanguage = true,
                ) }
            }
            TranslateEvent.OpenToLanguageDropDown -> {
                _state.update { it.copy(
                    isChoosingToLanguage = true,
                ) }
            }
        else -> Unit
        }
    }
    private fun translate(state: TranslateState) {
        if(state.isTranslating || state.fromText.isBlank()) {
            return
        }
        /**
         * Update the state to set translating to true
         */
        translateJob = viewModelScope.launch {
            _state.update { it.copy(
                isTranslating = true
            ) }
            val result = translateUseCase.execute(
                fromLanguage = state.fromLanguage.language,
                fromText = state.fromText,
                toLanguage = state.toLanguage.language
            )

            when(result) {
                is Resource.Success -> {
                    _state.update { it.copy(
                        isTranslating = false,
                        toText = result.data
                    ) }
                }
                is Resource.Error -> {
                    _state.update { it.copy(
                        isTranslating = false,
                        error = (result.throwable as? TranslateException)?.error
                    ) }
                }
            }
        }
    }
}