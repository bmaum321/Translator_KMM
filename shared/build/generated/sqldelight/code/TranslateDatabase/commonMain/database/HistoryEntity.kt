package database

import kotlin.Long
import kotlin.String

public data class HistoryEntity(
  public val id: Long,
  public val fromLanguageCode: String,
  public val fromText: String,
  public val toLanguageCode: String,
  public val toText: String,
  public val timestamp: Long
) {
  public override fun toString(): String = """
  |HistoryEntity [
  |  id: $id
  |  fromLanguageCode: $fromLanguageCode
  |  fromText: $fromText
  |  toLanguageCode: $toLanguageCode
  |  toText: $toText
  |  timestamp: $timestamp
  |]
  """.trimMargin()
}
