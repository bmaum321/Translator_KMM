package com.brian.translator_kmm.core.domain.util

/**
 * A quicker way of saying
 * fun DisposableHandle(block: () -> Unit): DisposableHandle {
 * return object: DisposableHandle {
 *      override fun dispose() {
 *          block()
 *          }
 *       }
 *    }
 */
fun interface DisposableHandle: kotlinx.coroutines.DisposableHandle