package com.brian.translator_kmm.translate.data.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J)\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/brian/translator_kmm/translate/data/remote/FakeTranslateClient;", "Lcom/brian/translator_kmm/translate/domain/translate/TranslateClient;", "()V", "translatedText", "", "getTranslatedText", "()Ljava/lang/String;", "setTranslatedText", "(Ljava/lang/String;)V", "translate", "fromLanguage", "Lcom/brian/translator_kmm/core/domain/language/Language;", "fromText", "toLanguage", "(Lcom/brian/translator_kmm/core/domain/language/Language;Ljava/lang/String;Lcom/brian/translator_kmm/core/domain/language/Language;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "androidApp_debug"})
public final class FakeTranslateClient implements com.brian.translator_kmm.translate.domain.translate.TranslateClient {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String translatedText = "test translation";
    
    public FakeTranslateClient() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTranslatedText() {
        return null;
    }
    
    public final void setTranslatedText(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object translate(@org.jetbrains.annotations.NotNull()
    com.brian.translator_kmm.core.domain.language.Language fromLanguage, @org.jetbrains.annotations.NotNull()
    java.lang.String fromText, @org.jetbrains.annotations.NotNull()
    com.brian.translator_kmm.core.domain.language.Language toLanguage, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> continuation) {
        return null;
    }
}