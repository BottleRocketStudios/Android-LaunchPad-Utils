package com.bottlerocketstudios.launchpad.utils.sharedpref

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class StringSetPreferenceDelegate(private val sharedPrefs: SharedPreferences?) : ReadWriteProperty<Any, Set<String>> {
    override fun getValue(thisRef: Any, property: KProperty<*>) = sharedPrefs?.getStringSet(property.name, setOf()) ?: setOf()

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Set<String>) {
        sharedPrefs?.edit()?.apply {
            putStringSet(property.name, value)
            apply()
        }
    }
}
