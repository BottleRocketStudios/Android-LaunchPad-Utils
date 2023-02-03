package com.bottlerocketstudios.launchpad.utils.logger

/** Wrapper for Logging utility. Implement either the TimberLogger or Android Logger in DI. */
interface LoggingManager {
    /** If using AndroidLogger, note [timberArgs] will be ignored. */
    fun v(tag: String?, message: String?, vararg timberArgs: Any? = emptyArray(), t: Throwable?)
    fun d(tag: String?, message: String?, vararg timberArgs: Any? = emptyArray(), t: Throwable?)
    fun i(tag: String?, message: String?, vararg timberArgs: Any? = emptyArray(), t: Throwable?)
    fun w(tag: String?, message: String?, vararg timberArgs: Any? = emptyArray(), t: Throwable?)
    fun e(tag: String?, message: String?, vararg timberArgs: Any? = emptyArray(), t: Throwable?)
    fun wtf(tag: String?, message: String?, vararg timberArgs: Any? = emptyArray(), t: Throwable?)
}