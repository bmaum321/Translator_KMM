package com.brian.translator_kmm.translate.domain.history

import com.brian.translator_kmm.core.domain.util.CommonFlow

interface HistoryDataSource {
    fun getHistory(): CommonFlow<List<HistoryItem>>

    suspend fun insertHistoryItem(historyItem: HistoryItem)

    suspend fun clearHistory()

    suspend fun insertAllHistoryItems(historyItems: List<HistoryItem>)
}