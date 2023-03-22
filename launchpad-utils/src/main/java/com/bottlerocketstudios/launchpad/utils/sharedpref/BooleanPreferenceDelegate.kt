package com.bottlerocketstudios.launchpad.utils.sharedpref

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class BooleanPreferenceDelegate(private val sharedPrefs: SharedPreferences?) : ReadWriteProperty<Any, Boolean> {
    override fun getValue(thisRef: Any, property: KProperty<*>) = sharedPrefs?.getBoolean(property.name, false) ?: false

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Boolean) {
        sharedPrefs?.edit()?.apply {
            putBoolean(property.name, value)
            apply()
        }
    }
}
