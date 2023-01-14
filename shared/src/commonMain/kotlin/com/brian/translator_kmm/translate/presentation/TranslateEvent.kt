package com.brian.translator_kmm.translate.presentation

import com.brian.translator_kmm.core.presentation.UiLanguage

/**

 * This class contains different events in the UI that can be sent to the viewmodel
 *
 * This could be a sealed interface because we don't have any constructor values but a sealed class
 * translates a little better for IOS code. A sealed interface will create separate classes for each
 * object under an interface
 */

sealed class TranslateEvent {
    data class ChooseFromLanguage(val language: UiLanguage): TranslateEvent()
    data class ChooseToLanguage(val language: UiLanguage): TranslateEvent()
    object StopChoosingLanguage: TranslateEvent()
    object SwapLanguages: TranslateEvent()
    data class ChangeTranslationText(val text: String): TranslateEvent()
    object Translate: TranslateEvent()
    object OpenFromLanguageDropDown: TranslateEvent()
    object OpenToLanguageDropDown: TranslateEvent()
    object CloseTranslation: TranslateEvent()
    data class SelectHistoryItem(val item: UiHistoryItem): TranslateEvent()
    object EditTranslation: TranslateEvent()
    object RecordAudio: TranslateEvent()
    data class SubmitVoiceResult(val result: String?): TranslateEvent()
    object OnErrorScreen: TranslateEvent()
    object ClearTranslateHistory: TranslateEvent()
    object InsertAllHistoryItems: TranslateEvent()

}
