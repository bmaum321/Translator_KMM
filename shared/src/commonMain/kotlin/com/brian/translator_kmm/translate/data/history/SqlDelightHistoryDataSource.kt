package com.brian.translator_kmm.translate.data.history

import com.brian.translator_kmm.core.domain.util.CommonFlow
import com.brian.translator_kmm.core.domain.util.toCommonFlow
import com.brian.translator_kmm.database.TranslateDatabase
import com.brian.translator_kmm.translate.domain.history.HistoryDataSource
import com.brian.translator_kmm.translate.domain.history.HistoryItem
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime

class SqlDelightHistoryDataSource(
    db: TranslateDatabase
): HistoryDataSource {

    private val queries = db.translateQueries

    override fun getHistory(): CommonFlow<List<HistoryItem>> {
        return queries
            .getHistory()
            .asFlow()
            .mapToList()
            .map { history ->
                history.map { it.toHistoryItem() }
            }
            .toCommonFlow()
    }

    /**
     * We cant use jave libraries in shared KMM files, therefore we are using the kotlin
     * date time library
     */
    override suspend fun insertHistoryItem(item: HistoryItem) {
        queries.insertHistoryEntity(
            id = item.id,
            fromLanguageCode = item.fromLanguageCode,
            fromText = item.fromText,
            toLanguageCode = item.toLanguageCode,
            toText = item.toText,
            timestamp = Clock.System.now().toEpochMilliseconds()
        )
    }
}