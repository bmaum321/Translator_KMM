package com.brian.translator_kmm.android.tranaslate.presentation.components;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aR\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003\u001a\u00aa\u0001\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\t2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001ab\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0003\u00a8\u0006\u0017"}, d2 = {"IdleTranslateTextField", "", "fromText", "", "isTranslating", "", "onTranslateClick", "Lkotlin/Function0;", "onTextChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "onClearClick", "TranslateTextField", "toText", "fromLanguage", "Lcom/brian/translator_kmm/core/presentation/UiLanguage;", "toLanguage", "onCopyClick", "onSpeakerClick", "onTextFieldClick", "onCloseClick", "TranslatedTextField", "androidApp_debug"})
public final class TranslateTextFieldKt {
    
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {androidx.compose.animation.ExperimentalAnimationApi.class})
    public static final void TranslateTextField(@org.jetbrains.annotations.NotNull()
    java.lang.String fromText, @org.jetbrains.annotations.Nullable()
    java.lang.String toText, boolean isTranslating, @org.jetbrains.annotations.NotNull()
    com.brian.translator_kmm.core.presentation.UiLanguage fromLanguage, @org.jetbrains.annotations.NotNull()
    com.brian.translator_kmm.core.presentation.UiLanguage toLanguage, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onTranslateClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onTextChange, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onCopyClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSpeakerClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onTextFieldClick, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onCloseClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClearClick) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void TranslatedTextField(java.lang.String fromText, java.lang.String toText, com.brian.translator_kmm.core.presentation.UiLanguage fromLanguage, com.brian.translator_kmm.core.presentation.UiLanguage toLanguage, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onCopyClick, kotlin.jvm.functions.Function0<kotlin.Unit> onCloseClick, kotlin.jvm.functions.Function0<kotlin.Unit> onSpeakerClick, androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void IdleTranslateTextField(java.lang.String fromText, boolean isTranslating, kotlin.jvm.functions.Function0<kotlin.Unit> onTranslateClick, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onTextChange, androidx.compose.ui.Modifier modifier, kotlin.jvm.functions.Function0<kotlin.Unit> onClearClick) {
    }
}