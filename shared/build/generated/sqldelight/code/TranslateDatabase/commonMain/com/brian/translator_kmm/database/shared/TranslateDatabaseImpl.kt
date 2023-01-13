package com.brian.translator_kmm.database.shared

import com.brian.translator_kmm.database.TranslateDatabase
import com.squareup.sqldelight.Query
import com.squareup.sqldelight.TransacterImpl
import com.squareup.sqldelight.`internal`.copyOnWriteList
import com.squareup.sqldelight.db.SqlDriver
import database.HistoryEntity
import database.TranslateQueries
import kotlin.Any
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Unit
import kotlin.collections.MutableList
import kotlin.reflect.KClass

internal val KClass<TranslateDatabase>.schema: SqlDriver.Schema
  get() = TranslateDatabaseImpl.Schema

internal fun KClass<TranslateDatabase>.newInstance(driver: SqlDriver): TranslateDatabase =
    TranslateDatabaseImpl(driver)

private class TranslateDatabaseImpl(
  driver: SqlDriver
) : TransacterImpl(driver), TranslateDatabase {
  public override val translateQueries: TranslateQueriesImpl = TranslateQueriesImpl(this, driver)

  public object Schema : SqlDriver.Schema {
    public override val version: Int
      get() = 1

    public override fun create(driver: SqlDriver): Unit {
      driver.execute(null, """
          |CREATE TABLE historyEntity(
          |    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
          |    fromLanguageCode TEXT NOT NULL,
          |    fromText TEXT NOT NULL,
          |    toLanguageCode TEXT NOT NULL,
          |    toText TEXT NOT NULL,
          |    timestamp INTEGER NOT NULL
          |)
          """.trimMargin(), 0)
    }

    public override fun migrate(
      driver: SqlDriver,
      oldVersion: Int,
      newVersion: Int
    ): Unit {
    }
  }
}

private class TranslateQueriesImpl(
  private val database: TranslateDatabaseImpl,
  private val driver: SqlDriver
) : TransacterImpl(driver), TranslateQueries {
  internal val getHistory: MutableList<Query<*>> = copyOnWriteList()

  public override fun <T : Any> getHistory(mapper: (
    id: Long,
    fromLanguageCode: String,
    fromText: String,
    toLanguageCode: String,
    toText: String,
    timestamp: Long
  ) -> T): Query<T> = Query(-1074477733, getHistory, driver, "translate.sq", "getHistory", """
  |SELECT *
  |FROM historyEntity
  |ORDER BY timestamp DESC
  """.trimMargin()) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3)!!,
      cursor.getString(4)!!,
      cursor.getLong(5)!!
    )
  }

  public override fun getHistory(): Query<HistoryEntity> = getHistory { id, fromLanguageCode,
      fromText, toLanguageCode, toText, timestamp ->
    HistoryEntity(
      id,
      fromLanguageCode,
      fromText,
      toLanguageCode,
      toText,
      timestamp
    )
  }

  public override fun clearHistory(): Unit {
    driver.execute(1701240644, """
    |DELETE
    |FROM historyEntity
    """.trimMargin(), 0)
    notifyQueries(1701240644, {database.translateQueries.getHistory})
  }

  public override fun insertHistoryEntity(
    id: Long?,
    fromLanguageCode: String,
    fromText: String,
    toLanguageCode: String,
    toText: String,
    timestamp: Long
  ): Unit {
    driver.execute(-1004011775, """
    |INSERT OR REPLACE
    |INTO historyEntity(
    |    id,
    |    fromLanguageCode,
    |    fromText,
    |    toLanguageCode,
    |    toText,
    |    timestamp
    |)
    |VALUES (?,?,?,?,?,?)
    """.trimMargin(), 6) {
      bindLong(1, id)
      bindString(2, fromLanguageCode)
      bindString(3, fromText)
      bindString(4, toLanguageCode)
      bindString(5, toText)
      bindLong(6, timestamp)
    }
    notifyQueries(-1004011775, {database.translateQueries.getHistory})
  }
}
