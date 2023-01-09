package com.brian.translator_kmm.database

import com.brian.translator_kmm.database.shared.newInstance
import com.brian.translator_kmm.database.shared.schema
import com.squareup.sqldelight.Transacter
import com.squareup.sqldelight.db.SqlDriver
import database.TranslateQueries

public interface TranslateDatabase : Transacter {
  public val translateQueries: TranslateQueries

  public companion object {
    public val Schema: SqlDriver.Schema
      get() = TranslateDatabase::class.schema

    public operator fun invoke(driver: SqlDriver): TranslateDatabase =
        TranslateDatabase::class.newInstance(driver)
  }
}
