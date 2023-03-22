package com.bottlerocketstudios.launchpad.utils.logger

import com.bottlerocketstudios.launchpad.utils.domain.BuildConfigProvider
import com.bottlerocketstudios.launchpad.utils.domain.logger.LoggingManager
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import timber.log.Timber

class TimberLogger : LoggingManager, KoinComponent {

    private val buildConfigProvider: BuildConfigProvider by inject()
    override fun v(tag: String?, message: String?, vararg timberArgs: Any?, t: Throwable?) {
        if (buildConfigProvider.isDebugOrInternalBuild) {
            tag?.let {
                Timber.tag(it).v(t, message, timberArgs)
            } ?: Timber.v(t, message, timberArgs)
        }
    }

    override fun d(tag: String?, message: String?, vararg timberArgs: Any?, t: Throwable?) {
        if (buildConfigProvider.isDebugOrInternalBuild) {
            tag?.let {
                Timber.tag(it).d(t, message, timberArgs)
            } ?: Timber.d(t, message, timberArgs)
        }
    }

    override fun i(tag: String?, message: String?, vararg timberArgs: Any?, t: Throwable?) {
        if (buildConfigProvider.isDebugOrInternalBuild) {
            tag?.let {
                Timber.tag(it).i(t, message, timberArgs)
            } ?: Timber.i(t, message, timberArgs)
        }
    }

    override fun w(tag: String?, message: String?, vararg timberArgs: Any?, t: Throwable?) {
        if (buildConfigProvider.isDebugOrInternalBuild) {
            tag?.let {
                Timber.tag(it).w(t, message, timberArgs)
            } ?: Timber.w(t, message, timberArgs)
        }
    }

    override fun e(tag: String?, message: String?, vararg timberArgs: Any?, t: Throwable?) {
        if (buildConfigProvider.isDebugOrInternalBuild) {
            tag?.let {
                Timber.tag(it).e(t, message, timberArgs)
            } ?: Timber.e(t, message, timberArgs)
        }
    }

    override fun wtf(tag: String?, message: String?, vararg timberArgs: Any?, t: Throwable?) {
        tag?.let {
            Timber.tag(it).wtf(t, message, timberArgs)
        } ?: Timber.wtf(t, message, timberArgs)
    }
}