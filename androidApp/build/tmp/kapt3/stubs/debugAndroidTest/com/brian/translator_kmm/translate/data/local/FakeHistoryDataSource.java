package com.brian.translator_kmm.translate.data.local;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000bH\u0016J\u001f\u0010\f\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/brian/translator_kmm/translate/data/local/FakeHistoryDataSource;", "Lcom/brian/translator_kmm/translate/domain/history/HistoryDataSource;", "()V", "_data", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/brian/translator_kmm/translate/domain/history/HistoryItem;", "clearHistory", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHistory", "Lcom/brian/translator_kmm/core/domain/util/CommonFlow;", "insertAllHistoryItems", "historyItems", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertHistoryItem", "historyItem", "(Lcom/brian/translator_kmm/translate/domain/history/HistoryItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "androidApp_debug"})
public final class FakeHistoryDataSource implements com.brian.translator_kmm.translate.domain.history.HistoryDataSource {
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.brian.translator_kmm.translate.domain.history.HistoryItem>> _data = null;
    
    public FakeHistoryDataSource() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.brian.translator_kmm.core.domain.util.CommonFlow<java.util.List<com.brian.translator_kmm.translate.domain.history.HistoryItem>> getHistory() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object insertHistoryItem(@org.jetbrains.annotations.NotNull()
    com.brian.translator_kmm.translate.domain.history.HistoryItem historyItem, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object clearHistory(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object insertAllHistoryItems(@org.jetbrains.annotations.NotNull()
    java.util.List<com.brian.translator_kmm.translate.domain.history.HistoryItem> historyItems, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}