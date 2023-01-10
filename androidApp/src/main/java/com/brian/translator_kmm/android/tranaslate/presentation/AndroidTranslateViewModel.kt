package com.brian.translator_kmm.android.tranaslate.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brian.translator_kmm.translate.domain.history.HistoryDataSource
import com.brian.translator_kmm.translate.domain.translate.TranslateUseCase
import com.brian.translator_kmm.translate.presentation.TranslateEvent
import com.brian.translator_kmm.translate.presentation.TranslateViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * This app is following the MVI pattern which only has one exposed state and on single function
 * to accept UI events
 */
@HiltViewModel
class AndroidTranslateViewModel @Inject constructor(
    private val translateUseCase: TranslateUseCase,
    private val historyDataSource: HistoryDataSource
): ViewModel() {

    private val viewModel by lazy {
        TranslateViewModel(
            coroutineScope = viewModelScope,
            translateUseCase = translateUseCase,
            historyDataSource = historyDataSource
        )
    }

    val state = viewModel.state

    fun onEvent(event: TranslateEvent) {
        viewModel.onEvent(event)
    }
}