package com.bottlerocketstudios.launchpad.utils

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow

fun flowTimer(delayMillis: Long) = flow {
    delay(delayMillis)
    emit(Unit)
}

@ExperimentalCoroutinesApi
fun <T> Flow<T>.throttleLatest(periodMillis: Long): Flow<T> {
    require(periodMillis > 0) { "period should be positive" }

    return channelFlow {
        var lastTime = 0L

        // collectLatest will cancel previous actions if they are still running
        collectLatest {
            System.currentTimeMillis().let { currentTime ->
                // Delay until periodMillis has elapsed since last emit
                (currentTime - lastTime).let { delta ->
                    if (delta < periodMillis) delay(periodMillis - delta)
                }

                send(it)
                lastTime = currentTime
            }
        }
    }
}