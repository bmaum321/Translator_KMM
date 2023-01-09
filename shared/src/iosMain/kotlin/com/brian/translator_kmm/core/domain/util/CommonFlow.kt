package com.brian.translator_kmm.core.domain.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

/**
 * We use a wrapper class here because we cant expose a Flow directly to IOS
 */
actual open class CommonFlow<T> actual constructor(
    private val flow: Flow<T>
): Flow<T> by flow {

    /**
     * We need to collect flows in a way that works for IOS
     */
    fun subscribe(
        coroutineScope: CoroutineScope,
        dispatcher: CoroutineDispatcher,
        onCollect: (T) -> Unit
    ): DisposableHandle { // A handler to dispose a job
        val job = coroutineScope.launch(dispatcher) {
            flow.collect(onCollect)
        }
        return DisposableHandle { job.cancel() }
    }
}