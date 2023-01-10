package com.brian.translator_kmm.android.tranaslate.presentation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u00a8\u0006\u0007"}, d2 = {"TranslateScreen", "", "state", "Lcom/brian/translator_kmm/translate/presentation/TranslateState;", "onEvent", "Lkotlin/Function1;", "Lcom/brian/translator_kmm/translate/presentation/TranslateEvent;", "androidApp_debug"})
public final class TranslateScreenKt {
    
    /**
     * An advantage of passing a state here instead of a viewmodel is that it makes the UI much easier to test.
     * If you passed a viewmodel that had several dependencies you would have to create fakes for all of them
     * just to write a UI tests. Here we just pass a state instead
     */
    @androidx.compose.runtime.Composable()
    public static final void TranslateScreen(@org.jetbrains.annotations.NotNull()
    com.brian.translator_kmm.translate.presentation.TranslateState state, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.brian.translator_kmm.translate.presentation.TranslateEvent, kotlin.Unit> onEvent) {
    }
}