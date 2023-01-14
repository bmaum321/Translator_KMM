package com.brian.translator_kmm.android.voiceToText.di

import android.app.Application
import com.brian.translator_kmm.android.voiceToText.data.AndroidVoiceToTextParser
import com.brian.translator_kmm.voicetotext.domain.VoiceToTextParser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * We are installing in viewmodel because we only want the dependencies to live as
 * long as the viewmodel lives
 */
@Module
@InstallIn(ViewModelComponent::class)
object VoiceToTextModule {

    @Provides
    @ViewModelScoped
    fun providedVoiceToTextParser(app: Application): VoiceToTextParser {
        return AndroidVoiceToTextParser(app)
    }
}