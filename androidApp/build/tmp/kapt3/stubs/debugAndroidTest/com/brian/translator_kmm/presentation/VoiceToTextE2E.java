package com.brian.translator_kmm.presentation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0007J\b\u0010\u001b\u001a\u00020\u001aH\u0007R%\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u00048G\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u00020\u00168G\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/brian/translator_kmm/presentation/VoiceToTextE2E;", "", "()V", "composeRule", "Landroidx/compose/ui/test/junit4/AndroidComposeTestRule;", "Landroidx/test/ext/junit/rules/ActivityScenarioRule;", "Lcom/brian/translator_kmm/android/MainActivity;", "getComposeRule", "()Landroidx/compose/ui/test/junit4/AndroidComposeTestRule;", "fakeClient", "Lcom/brian/translator_kmm/translate/domain/translate/TranslateClient;", "getFakeClient", "()Lcom/brian/translator_kmm/translate/domain/translate/TranslateClient;", "setFakeClient", "(Lcom/brian/translator_kmm/translate/domain/translate/TranslateClient;)V", "fakeVoiceParser", "Lcom/brian/translator_kmm/voicetotext/domain/VoiceToTextParser;", "getFakeVoiceParser", "()Lcom/brian/translator_kmm/voicetotext/domain/VoiceToTextParser;", "setFakeVoiceParser", "(Lcom/brian/translator_kmm/voicetotext/domain/VoiceToTextParser;)V", "hiltRule", "Ldagger/hilt/android/testing/HiltAndroidRule;", "getHiltRule", "()Ldagger/hilt/android/testing/HiltAndroidRule;", "recordAndTranslate", "", "setUp", "androidApp_debug"})
@dagger.hilt.android.testing.UninstallModules(value = {com.brian.translator_kmm.android.di.AppModule.class, com.brian.translator_kmm.android.voiceToText.di.VoiceToTextModule.class})
@dagger.hilt.android.testing.HiltAndroidTest()
public final class VoiceToTextE2E {
    
    /**
     * Our compose test rule here uses main activity, so the app just launches and we cant inject fake
     * viewmodels manually.
     *
     * So we use dagger hilt to then inject fakes into our main activity
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.ui.test.junit4.AndroidComposeTestRule<androidx.test.ext.junit.rules.ActivityScenarioRule<com.brian.translator_kmm.android.MainActivity>, com.brian.translator_kmm.android.MainActivity> composeRule = null;
    @org.jetbrains.annotations.NotNull()
    private final dagger.hilt.android.testing.HiltAndroidRule hiltRule = null;
    @javax.inject.Inject()
    public com.brian.translator_kmm.voicetotext.domain.VoiceToTextParser fakeVoiceParser;
    @javax.inject.Inject()
    public com.brian.translator_kmm.translate.domain.translate.TranslateClient fakeClient;
    
    public VoiceToTextE2E() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.junit.Rule()
    public final androidx.compose.ui.test.junit4.AndroidComposeTestRule<androidx.test.ext.junit.rules.ActivityScenarioRule<com.brian.translator_kmm.android.MainActivity>, com.brian.translator_kmm.android.MainActivity> getComposeRule() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.junit.Rule()
    public final dagger.hilt.android.testing.HiltAndroidRule getHiltRule() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.brian.translator_kmm.voicetotext.domain.VoiceToTextParser getFakeVoiceParser() {
        return null;
    }
    
    public final void setFakeVoiceParser(@org.jetbrains.annotations.NotNull()
    com.brian.translator_kmm.voicetotext.domain.VoiceToTextParser p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.brian.translator_kmm.translate.domain.translate.TranslateClient getFakeClient() {
        return null;
    }
    
    public final void setFakeClient(@org.jetbrains.annotations.NotNull()
    com.brian.translator_kmm.translate.domain.translate.TranslateClient p0) {
    }
    
    /**
     * Inject our fake dependencies
     */
    @org.junit.Before()
    public final void setUp() {
    }
    
    @org.junit.Test()
    public final void recordAndTranslate() {
    }
}