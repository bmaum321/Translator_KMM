package com.brian.translator_kmm.android.tranaslate.presentation;

import java.lang.System;

/**
 * This app is following the MVI pattern which only has one exposed state and on single function
 * to accept UI events
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/brian/translator_kmm/android/tranaslate/presentation/AndroidTranslateViewModel;", "Landroidx/lifecycle/ViewModel;", "translateUseCase", "Lcom/brian/translator_kmm/translate/domain/translate/TranslateUseCase;", "historyDataSource", "Lcom/brian/translator_kmm/translate/domain/history/HistoryDataSource;", "(Lcom/brian/translator_kmm/translate/domain/translate/TranslateUseCase;Lcom/brian/translator_kmm/translate/domain/history/HistoryDataSource;)V", "state", "Lcom/brian/translator_kmm/core/domain/util/CommonStateFlow;", "Lcom/brian/translator_kmm/translate/presentation/TranslateState;", "getState", "()Lcom/brian/translator_kmm/core/domain/util/CommonStateFlow;", "viewModel", "Lcom/brian/translator_kmm/translate/presentation/TranslateViewModel;", "getViewModel", "()Lcom/brian/translator_kmm/translate/presentation/TranslateViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onEvent", "", "event", "Lcom/brian/translator_kmm/translate/presentation/TranslateEvent;", "androidApp_debug"})
public final class AndroidTranslateViewModel extends androidx.lifecycle.ViewModel {
    private final com.brian.translator_kmm.translate.domain.translate.TranslateUseCase translateUseCase = null;
    private final com.brian.translator_kmm.translate.domain.history.HistoryDataSource historyDataSource = null;
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final com.brian.translator_kmm.core.domain.util.CommonStateFlow<com.brian.translator_kmm.translate.presentation.TranslateState> state = null;
    
    @javax.inject.Inject()
    public AndroidTranslateViewModel(@org.jetbrains.annotations.NotNull()
    com.brian.translator_kmm.translate.domain.translate.TranslateUseCase translateUseCase, @org.jetbrains.annotations.NotNull()
    com.brian.translator_kmm.translate.domain.history.HistoryDataSource historyDataSource) {
        super();
    }
    
    private final com.brian.translator_kmm.translate.presentation.TranslateViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.brian.translator_kmm.core.domain.util.CommonStateFlow<com.brian.translator_kmm.translate.presentation.TranslateState> getState() {
        return null;
    }
    
    public final void onEvent(@org.jetbrains.annotations.NotNull()
    com.brian.translator_kmm.translate.presentation.TranslateEvent event) {
    }
}