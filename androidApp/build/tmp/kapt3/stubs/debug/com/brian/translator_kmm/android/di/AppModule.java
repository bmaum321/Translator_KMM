package com.brian.translator_kmm.android.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\bH\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/brian/translator_kmm/android/di/AppModule;", "", "()V", "provideDatabaseDriver", "Lcom/squareup/sqldelight/db/SqlDriver;", "app", "Landroid/app/Application;", "provideHistoryDataSource", "Lcom/brian/translator_kmm/translate/domain/history/HistoryDataSource;", "driver", "provideHttpClient", "Lio/ktor/client/HttpClient;", "provideTranslateClient", "Lcom/brian/translator_kmm/translate/domain/translate/TranslateClient;", "httpClient", "provideTranslateUseCase", "Lcom/brian/translator_kmm/translate/domain/translate/TranslateUseCase;", "client", "dataSource", "androidApp_debug"})
@dagger.Module()
public final class AppModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.brian.translator_kmm.android.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final io.ktor.client.HttpClient provideHttpClient() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.brian.translator_kmm.translate.domain.translate.TranslateClient provideTranslateClient(@org.jetbrains.annotations.NotNull()
    io.ktor.client.HttpClient httpClient) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.squareup.sqldelight.db.SqlDriver provideDatabaseDriver(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.brian.translator_kmm.translate.domain.history.HistoryDataSource provideHistoryDataSource(@org.jetbrains.annotations.NotNull()
    com.squareup.sqldelight.db.SqlDriver driver) {
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
}