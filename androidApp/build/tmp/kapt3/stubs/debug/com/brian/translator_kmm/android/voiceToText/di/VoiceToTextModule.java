package com.brian.translator_kmm.android.voiceToText.di;

import java.lang.System;

/**
 * We are installing in viewmodel because we only want the dependencies to live as
 * long as the viewmodel lives
 */
@dagger.hilt.InstallIn(value = {dagger.hilt.android.components.ViewModelComponent.class})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/brian/translator_kmm/android/voiceToText/di/VoiceToTextModule;", "", "()V", "providedVoiceToTextParser", "Lcom/brian/translator_kmm/voicetotext/domain/VoiceToTextParser;", "app", "Landroid/app/Application;", "androidApp_debug"})
@dagger.Module()
public final class VoiceToTextModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.brian.translator_kmm.android.voiceToText.di.VoiceToTextModule INSTANCE = null;
    
    private VoiceToTextModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.scopes.ViewModelScoped()
    @dagger.Provides()
    public final com.brian.translator_kmm.voicetotext.domain.VoiceToTextParser providedVoiceToTextParser(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        return null;
    }
}