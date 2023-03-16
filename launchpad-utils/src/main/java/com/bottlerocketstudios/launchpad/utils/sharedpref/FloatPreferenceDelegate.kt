package com.bottlerocketstudios.launchpad.utils.sharedpref

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class FloatPreferenceDelegate(private val sharedPrefs: SharedPreferences?) : ReadWriteProperty<Any, Float> {
    override fun getValue(thisRef: Any, property: KProperty<*>) = sharedPrefs?.getFloat(property.name, 0f) ?: 0f

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Float) {
        sharedPrefs?.edit()?.apply {
            putFloat(property.name, value)
            apply()
        }
    }
}