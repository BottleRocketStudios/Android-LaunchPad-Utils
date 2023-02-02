package com.bottlerocketstudios.launchpad.utils.logger

import android.util.Log

@Suppress("LogNotTimber")
class AndroidLogger : LoggingManager {
    override fun v(tag: String?, message: String?, vararg args: Any?, t: Throwable?) {
        Log.v(tag, message, t)
    }

    override fun d(tag: String?, message: String?, vararg args: Any?, t: Throwable?) {
        Log.d(tag, message, t)
    }

    override fun i(tag: String?, message: String?, vararg args: Any?, t: Throwable?) {
        Log.i(tag, message, t)
    }

    override fun w(tag: String?, message: String?, vararg args: Any?, t: Throwable?) {
        Log.w(tag, message, t)
    }

    override fun e(tag: String?, message: String?, vararg args: Any?, t: Throwable?) {
        Log.e(tag, message, t)
    }

    override fun wtf(tag: String?, message: String?, vararg args: Any?, t: Throwable?) {
        Log.wtf(tag, message, t)
    }
}