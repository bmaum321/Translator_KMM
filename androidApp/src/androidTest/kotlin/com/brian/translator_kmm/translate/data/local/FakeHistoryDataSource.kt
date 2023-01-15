package com.brian.translator_kmm.translate.data.local

import com.brian.translator_kmm.core.domain.util.CommonFlow
import com.brian.translator_kmm.core.domain.util.toCommonFlow
import com.brian.translator_kmm.translate.domain.history.HistoryDataSource
import com.brian.translator_kmm.translate.domain.history.HistoryItem
import kotlinx.coroutines.flow.MutableStateFlow

class FakeHistoryDataSource: HistoryDataSource {

    private val _data = MutableStateFlow<List<HistoryItem>>(emptyList())

    override fun getHistory(): CommonFlow<List<HistoryItem>> {
        return _data.toCommonFlow()
    }

    override suspend fun insertHistoryItem(historyItem: HistoryItem) {
        _data.value += historyItem
    }

    override suspend fun clearHistory() {
        _data.value = emptyList()
    }

    override suspend fun insertAllHistoryItems(historyItems: List<HistoryItem>) {
        _data.value += historyItems
    }
}