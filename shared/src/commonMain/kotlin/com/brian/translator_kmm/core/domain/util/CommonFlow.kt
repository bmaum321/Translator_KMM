package com.brian.translator_kmm.core.domain.util

import kotlinx.coroutines.flow.Flow

/**
 * expect class again because we need different implementations for IOS and android
 */

expect open class CommonFlow<T>(flow: Flow<T>): Flow<T>

fun <T> Flow<T>.toCommonFlow() = CommonFlow(this)