package com.bottlerocketstudios.launchpad.utils.sharedpref

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class LongPreferenceDelegate(private val sharedPrefs: SharedPreferences?) : ReadWriteProperty<Any, Long> {
    override fun getValue(thisRef: Any, property: KProperty<*>) = sharedPrefs?.getLong(property.name, 0L) ?: 0L

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Long) {
        sharedPrefs?.edit()?.apply {
            putLong(property.name, value)
            apply()
        }
    }
}