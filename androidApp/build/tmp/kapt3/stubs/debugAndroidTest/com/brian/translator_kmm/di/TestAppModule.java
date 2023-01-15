package com.brian.translator_kmm.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0007\u00a8\u0006\r"}, d2 = {"Lcom/brian/translator_kmm/di/TestAppModule;", "", "()V", "provideFakeHistoryDataSource", "Lcom/brian/translator_kmm/translate/domain/history/HistoryDataSource;", "provideFakeTranslateClient", "Lcom/brian/translator_kmm/translate/domain/translate/TranslateClient;", "provideFakeVoiceToTextParser", "Lcom/brian/translator_kmm/voicetotext/domain/VoiceToTextParser;", "provideTranslateUseCase", "Lcom/brian/translator_kmm/translate/domain/translate/TranslateUseCase;", "client", "dataSource", "androidApp_debug"})
@dagger.Module()
public final class TestAppModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.brian.translator_kmm.di.TestAppModule INSTANCE = null;
    
    private TestAppModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.brian.translator_kmm.translate.domain.translate.TranslateClient provideFakeTranslateClient() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.brian.translator_kmm.translate.domain.history.HistoryDataSource provideFakeHistoryDataSource() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.brian.translator_kmm.translate.domain.translate.TranslateUseCase provideTranslateUseCase(@org.jetbrains.annotations.NotNull()
    com.brian.translator_kmm.translate.domain.translate.TranslateClient client, @org.jetbrains.annotations.NotNull()
    com.brian.translator_kmm.translate.domain.history.HistoryDataSource dataSource) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.brian.translator_kmm.voicetotext.domain.VoiceToTextParser provideFakeVoiceToTextParser() {
        return null;
    }
}