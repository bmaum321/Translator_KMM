package com.brian.translator_kmm.translate.presentation

import com.brian.translator_kmm.core.presentation.UiLanguage
import com.brian.translator_kmm.translate.domain.history.HistoryItem
import com.brian.translator_kmm.translate.domain.translate.TranslateError

/**
 * This data class defines our Ui state
 */

data class TranslateState(
    val fromText: String = "",
    val toText: String? = null,
    val isTranslating: Boolean = false,
    val fromLanguage: UiLanguage = UiLanguage.byCode("en"),
    val toLanguage: UiLanguage = UiLanguage.byCode("es"),
    // These values determine if we should show the dropdown language selector
    val isChoosingFromLanguage: Boolean = false,
    val isChoosingToLanguage: Boolean = false,
    val error: TranslateError? = null,
    val history: List<UiHistoryItem> = emptyList(),
    val historyRecycleBin: List<HistoryItem> = emptyList()
)
