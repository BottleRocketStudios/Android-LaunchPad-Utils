package com.bottlerocketstudios.launchpad.utils.logger
//LogManagerAndroid (LogUtils)
//LogManagerTimber
interface LoggingManager {
    fun v(tag: String? = null, message: String?, vararg args: Any?, t: Throwable?)
    fun d(tag: String? = null, message: String?, vararg args: Any?, t: Throwable?)
    fun i(tag: String? = null, message: String?, vararg args: Any?, t: Throwable?)
    fun w(tag: String? = null, message: String?, vararg args: Any?, t: Throwable?)
    fun e(tag: String? = null, message: String?, vararg args: Any?, t: Throwable?)
    fun wtf(tag: String? = null, message: String?, vararg args: Any?, t: Throwable?)
}