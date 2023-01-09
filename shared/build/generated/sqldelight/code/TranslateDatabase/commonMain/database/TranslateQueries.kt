package database

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.Transacter
import kotlin.Any
import kotlin.Long
import kotlin.String
import kotlin.Unit

public interface TranslateQueries : Transacter {
  public fun <T : Any> getHistory(mapper: (
    id: Long,
    fromLanguageCode: String,
    fromText: String,
    toLanguageCode: String,
    toText: String,
    timestamp: Long
  ) -> T): Query<T>

  public fun getHistory(): Query<HistoryEntity>

  public fun insertHistoryEntity(
    id: Long?,
    fromLanguageCode: String,
    fromText: String,
    toLanguageCode: String,
    toText: String,
    timestamp: Long
  ): Unit
}
