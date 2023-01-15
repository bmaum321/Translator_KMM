package com.brian.translator_kmm.voicetotext.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/brian/translator_kmm/voicetotext/data/FakeVoiceToTextParser;", "Lcom/brian/translator_kmm/voicetotext/domain/VoiceToTextParser;", "()V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/brian/translator_kmm/voicetotext/domain/VoiceToTextParserState;", "state", "Lcom/brian/translator_kmm/core/domain/util/CommonStateFlow;", "getState", "()Lcom/brian/translator_kmm/core/domain/util/CommonStateFlow;", "voiceResult", "", "getVoiceResult", "()Ljava/lang/String;", "setVoiceResult", "(Ljava/lang/String;)V", "cancel", "", "reset", "startListening", "languageCode", "stopListening", "androidApp_debug"})
public final class FakeVoiceToTextParser implements com.brian.translator_kmm.voicetotext.domain.VoiceToTextParser {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String voiceResult = "test result";
    private final kotlinx.coroutines.flow.MutableStateFlow<com.brian.translator_kmm.voicetotext.domain.VoiceToTextParserState> _state = null;
    
    public FakeVoiceToTextParser() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getVoiceResult() {
        return null;
    }
    
    public final void setVoiceResult(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.brian.translator_kmm.core.domain.util.CommonStateFlow<com.brian.translator_kmm.voicetotext.domain.VoiceToTextParserState> getState() {
        return null;
    }
    
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
}