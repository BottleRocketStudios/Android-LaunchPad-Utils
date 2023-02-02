package com.bottlerocketstudios.launchpad.utils.logger

import timber.log.Timber

class TimberLogger : LoggingManager {
    override fun v(tag: String?, message: String?, vararg args: Any?, t: Throwable?) {
        Timber.tag(tag ?: "").v(t = t, message = message, args = args)
    }

    override fun d(tag: String?, message: String?, vararg args: Any?, t: Throwable?) {
        Timber.tag(tag ?: "").d(t = t, message = message, args = args)
    }

    override fun i(tag: String?, message: String?, vararg args: Any?, t: Throwable?) {
        Timber.tag(tag ?: "").i(t = t, message = message, args = args)
    }

    override fun w(tag: String?, message: String?, vararg args: Any?, t: Throwable?) {
        Timber.tag(tag ?: "").w(t = t, message = message, args = args)
    }

    override fun e(tag: String?, message: String?, vararg args: Any?, t: Throwable?) {
        Timber.tag(tag ?: "").e(t = t, message = message, args = args)
    }

    override fun wtf(tag: String?, message: String?, vararg args: Any?, t: Throwable?) {
        Timber.tag(tag ?: "").wtf(t = t, message = message, args = args)
    }
}