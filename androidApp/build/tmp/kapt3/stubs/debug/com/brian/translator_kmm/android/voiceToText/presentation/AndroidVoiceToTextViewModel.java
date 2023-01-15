package com.brian.translator_kmm.android.voiceToText.presentation;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/brian/translator_kmm/android/voiceToText/presentation/AndroidVoiceToTextViewModel;", "Landroidx/lifecycle/ViewModel;", "parser", "Lcom/brian/translator_kmm/voicetotext/domain/VoiceToTextParser;", "(Lcom/brian/translator_kmm/voicetotext/domain/VoiceToTextParser;)V", "state", "Lcom/brian/translator_kmm/core/domain/util/CommonStateFlow;", "Lcom/brian/translator_kmm/voicetotext/presentation/VoiceToTextState;", "getState", "()Lcom/brian/translator_kmm/core/domain/util/CommonStateFlow;", "viewModel", "Lcom/brian/translator_kmm/voicetotext/presentation/VoiceToTextViewModel;", "getViewModel", "()Lcom/brian/translator_kmm/voicetotext/presentation/VoiceToTextViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onEvent", "", "event", "Lcom/brian/translator_kmm/voicetotext/presentation/VoiceToTextEvent;", "androidApp_debug"})
public final class AndroidVoiceToTextViewModel extends androidx.lifecycle.ViewModel {
    private final com.brian.translator_kmm.voicetotext.domain.VoiceToTextParser parser = null;
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final com.brian.translator_kmm.core.domain.util.CommonStateFlow<com.brian.translator_kmm.voicetotext.presentation.VoiceToTextState> state = null;
    
    @javax.inject.Inject()
    public AndroidVoiceToTextViewModel(@org.jetbrains.annotations.NotNull()
    com.brian.translator_kmm.voicetotext.domain.VoiceToTextParser parser) {
        super();
    }
    
    private final com.brian.translator_kmm.voicetotext.presentation.VoiceToTextViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.brian.translator_kmm.core.domain.util.CommonStateFlow<com.brian.translator_kmm.voicetotext.presentation.VoiceToTextState> getState() {
        return null;
    }
    
    public final void onEvent(@org.jetbrains.annotations.NotNull()
    com.brian.translator_kmm.voicetotext.presentation.VoiceToTextEvent event) {
    }
}