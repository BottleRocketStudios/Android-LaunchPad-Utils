package com.bottlerocketstudios.launchpad.utils.logger

import android.util.Log
import com.bottlerocketstudios.launchpad.utils.BuildConfigProvider
import com.bottlerocketstudios.launchpad.utils.domain.logger.LoggingManager
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Suppress("LogNotTimber")
class AndroidLogger : LoggingManager, KoinComponent {

    private val buildConfigProvider: BuildConfigProvider by inject()

    /**
     * Makes a null check for throwable because if only tag and message are being passed, message cannot be null - hence [orEmpty].
     * Otherwise, message may be empty if throwable is not null.
     * https://developer.android.com/reference/android/util/Log
     */
    override fun v(tag: String?, message: String?, vararg timberArgs: Any?, t: Throwable?) {
        if (buildConfigProvider.isDebugOrInternalBuild) {
            t?.let { Log.v(tag, message, t) } ?: Log.v(tag, message.orEmpty())
        }
    }

    override fun d(tag: String?, message: String?, vararg timberArgs: Any?, t: Throwable?) {
        if (buildConfigProvider.isDebugOrInternalBuild) {
            t?.let { Log.d(tag, message, t) } ?: Log.d(tag, message.orEmpty())
        }
    }

    override fun i(tag: String?, message: String?, vararg timberArgs: Any?, t: Throwable?) {
        if (buildConfigProvider.isDebugOrInternalBuild) {
            t?.let { Log.i(tag, message, t) } ?: Log.i(tag, message.orEmpty())
        }
    }

    override fun w(tag: String?, message: String?, vararg timberArgs: Any?, t: Throwable?) {
        if (buildConfigProvider.isDebugOrInternalBuild) {
            t?.let { Log.w(tag, message, t) } ?: Log.w(tag, message.orEmpty())
        }
    }

    override fun e(tag: String?, message: String?, vararg timberArgs: Any?, t: Throwable?) {
        if (buildConfigProvider.isDebugOrInternalBuild) {
            t?.let { Log.e(tag, message, t) } ?: Log.e(tag, message.orEmpty())
        }
    }

    override fun wtf(tag: String?, message: String?, vararg timberArgs: Any?, t: Throwable?) {
        if (buildConfigProvider.isDebugOrInternalBuild) {
            t?.let { Log.wtf(tag, message, t) } ?: Log.wtf(tag, message.orEmpty())
        }
    }
}
