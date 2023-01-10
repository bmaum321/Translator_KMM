package com.brian.translator_kmm.android.di

import android.app.Application
import com.brian.translator_kmm.database.TranslateDatabase
import com.brian.translator_kmm.translate.data.history.SqlDelightHistoryDataSource
import com.brian.translator_kmm.translate.data.local.DatabaseDriverFactory
import com.brian.translator_kmm.translate.data.remote.HttpClientFactory
import com.brian.translator_kmm.translate.data.translate.KtorTranslateClient
import com.brian.translator_kmm.translate.domain.history.HistoryDataSource
import com.brian.translator_kmm.translate.domain.translate.TranslateClient
import com.brian.translator_kmm.translate.domain.translate.TranslateUseCase
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClientFactory().create()
    }

    @Provides
    @Singleton
    fun provideTranslateClient(httpClient: HttpClient): TranslateClient {
        return KtorTranslateClient(httpClient)
    }

    @Provides
    @Singleton
    fun provideDatabaseDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app.applicationContext).create()
    }

    @Provides
    @Singleton
    fun provideHistoryDataSource(driver: SqlDriver): HistoryDataSource {
        return SqlDelightHistoryDataSource(TranslateDatabase(driver))
    }

    @Provides
    @Singleton
    fun provideTranslateUseCase(
        client: TranslateClient,
        dataSource: HistoryDataSource)
    : TranslateUseCase {
        return TranslateUseCase(client, dataSource)
    }
}