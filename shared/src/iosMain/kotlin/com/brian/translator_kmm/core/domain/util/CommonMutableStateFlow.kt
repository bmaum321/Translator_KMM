package com.brian.translator_kmm.core.domain.util

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


/**
 * If we wanted to create a state flow on IOS, we would have to pass a mutable state flow as an ititial state to the
 * constructor which we cant do. So we have to create an abstraction which will allow us to do this
 */
actual open class CommonMutableStateFlow<T> actual constructor(
    private val flow: MutableStateFlow<T>
): CommonStateFlow<T>(flow), MutableStateFlow<T>{
    override val replayCache: List<T>
        get() = flow.replayCache

    override var value: T
        get() = super.value
        set(value) {
            flow.value = value
        }

    override suspend fun collect(collector: FlowCollector<T>): Nothing {
        flow.collect(collector)
    }

    override val subscriptionCount: StateFlow<Int>
        get() = flow.subscriptionCount

    override suspend fun emit(value: T) {
        flow.emit(value)
    }

    @ExperimentalCoroutinesApi
    override fun resetReplayCache() {
        flow.resetReplayCache()
    }

    override fun tryEmit(value: T): Boolean {
        return flow.tryEmit(value)
    }

    override fun compareAndSet(expect: T, update: T): Boolean {
        return flow.compareAndSet(expect, update)
    }

}