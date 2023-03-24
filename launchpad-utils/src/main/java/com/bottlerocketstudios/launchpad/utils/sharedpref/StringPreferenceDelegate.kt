package com.bottlerocketstudios.launchpad.utils.sharedpref

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class StringPreferenceDelegate(private val sharedPrefs: SharedPreferences?) : ReadWriteProperty<Any, String> {
    override fun getValue(thisRef: Any, property: KProperty<*>) = sharedPrefs?.getString(property.name, "").orEmpty()

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        sharedPrefs?.edit()?.apply {
            putString(property.name, value)
            apply()
        }
    }
}
