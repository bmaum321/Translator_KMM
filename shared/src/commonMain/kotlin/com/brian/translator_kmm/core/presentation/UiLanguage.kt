package com.brian.translator_kmm.core.presentation

import com.brian.translator_kmm.core.domain.language.Language

/**
 * This is an expect class, because the way we retrieve vector UI images is different on IOS
 * and Android. We use vector resources ids  (int) on Android and image names in IOS (string)
 */
expect class UiLanguage {
    val language: Language
    companion object {
        fun byCode(langCode: String): UiLanguage
        val allLanguages: List<UiLanguage>
    }
}