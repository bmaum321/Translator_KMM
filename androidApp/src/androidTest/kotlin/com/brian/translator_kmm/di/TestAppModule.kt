package com.brian.translator_kmm.di

import android.speech.tts.Voice
import com.brian.translator_kmm.translate.data.local.FakeHistoryDataSource
import com.brian.translator_kmm.translate.data.remote.FakeTranslateClient
import com.brian.translator_kmm.translate.domain.history.HistoryDataSource
import com.brian.translator_kmm.translate.domain.translate.TranslateClient
import com.brian.translator_kmm.translate.domain.translate.TranslateUseCase
import com.brian.translator_kmm.voicetotext.data.FakeVoiceToTextParser
import com.brian.translator_kmm.voicetotext.domain.VoiceToTextParser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    @Provides
    @Singleton
    fun provideFakeTranslateClient(): TranslateClient {
        return FakeTranslateClient()
    }

    @Provides
    @Singleton
    fun provideFakeHistoryDataSource(): HistoryDataSource{
        return FakeHistoryDataSource()
    }

    @Provides
    @Singleton
    fun provideTranslateUseCase(client: TranslateClient, dataSource: HistoryDataSource): TranslateUseCase {
        return TranslateUseCase(client,dataSource)
    }


    @Provides
    @Singleton
    fun provideFakeVoiceToTextParser(): VoiceToTextParser{
        return FakeVoiceToTextParser()
    }
}