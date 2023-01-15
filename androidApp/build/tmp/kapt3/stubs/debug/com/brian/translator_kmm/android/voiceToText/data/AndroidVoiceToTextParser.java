package com.brian.translator_kmm.android.voiceToText.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001e\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001f\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0011H\u0016J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\'H\u0016J\b\u0010(\u001a\u00020\u0011H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006)"}, d2 = {"Lcom/brian/translator_kmm/android/voiceToText/data/AndroidVoiceToTextParser;", "Lcom/brian/translator_kmm/voicetotext/domain/VoiceToTextParser;", "Landroid/speech/RecognitionListener;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/brian/translator_kmm/voicetotext/domain/VoiceToTextParserState;", "recognizer", "Landroid/speech/SpeechRecognizer;", "kotlin.jvm.PlatformType", "state", "Lcom/brian/translator_kmm/core/domain/util/CommonStateFlow;", "getState", "()Lcom/brian/translator_kmm/core/domain/util/CommonStateFlow;", "cancel", "", "onBeginningOfSpeech", "onBufferReceived", "p0", "", "onEndOfSpeech", "onError", "code", "", "onEvent", "p1", "Landroid/os/Bundle;", "onPartialResults", "onReadyForSpeech", "onResults", "result", "onRmsChanged", "rmsDb", "", "reset", "startListening", "languageCode", "", "stopListening", "androidApp_debug"})
public final class AndroidVoiceToTextParser implements com.brian.translator_kmm.voicetotext.domain.VoiceToTextParser, android.speech.RecognitionListener {
    private final android.app.Application app = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.brian.translator_kmm.voicetotext.domain.VoiceToTextParserState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final com.brian.translator_kmm.core.domain.util.CommonStateFlow<com.brian.translator_kmm.voicetotext.domain.VoiceToTextParserState> state = null;
    private final android.speech.SpeechRecognizer recognizer = null;
    
    public AndroidVoiceToTextParser(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.brian.translator_kmm.core.domain.util.CommonStateFlow<com.brian.translator_kmm.voicetotext.domain.VoiceToTextParserState> getState() {
        return null;
    }
    
    /**
     * When we start listening just start with a brand new state
     */
    @java.lang.Override()
    public void startListening(@org.jetbrains.annotations.NotNull()
    java.lang.String languageCode) {
    }
    
    @java.lang.Override()
    public void stopListening() {
    }
    
    @java.lang.Override()
    public void cancel() {
    }
    
    @java.lang.Override()
    public void reset() {
    }
    
    @java.lang.Override()
    public void onReadyForSpeech(@org.jetbrains.annotations.Nullable()
    android.os.Bundle p0) {
    }
    
    @java.lang.Override()
    public void onBeginningOfSpeech() {
    }
    
    @java.lang.Override()
    public void onRmsChanged(float rmsDb) {
    }
    
    @java.lang.Override()
    public void onBufferReceived(@org.jetbrains.annotations.Nullable()
    byte[] p0) {
    }
    
    @java.lang.Override()
    public void onEndOfSpeech() {
    }
    
    @java.lang.Override()
    public void onError(int code) {
    }
    
    @java.lang.Override()
    public void onResults(@org.jetbrains.annotations.Nullable()
    android.os.Bundle result) {
    }
    
    @java.lang.Override()
    public void onPartialResults(@org.jetbrains.annotations.Nullable()
    android.os.Bundle p0) {
    }
    
    @java.lang.Override()
    public void onEvent(int p0, @org.jetbrains.annotations.Nullable()
    android.os.Bundle p1) {
    }
}