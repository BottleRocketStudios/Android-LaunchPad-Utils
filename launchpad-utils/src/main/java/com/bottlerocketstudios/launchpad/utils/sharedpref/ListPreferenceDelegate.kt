package com.bottlerocketstudios.launchpad.utils.sharedpref

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class ListPreferenceDelegate<T>(
    private val sharedPrefs: SharedPreferences?,
    private val converter: (String) -> T?
) : ReadWriteProperty<Any, List<T>> {
    override fun getValue(thisRef: Any, property: KProperty<*>): List<T> {
        val listString = sharedPrefs?.getString(property.name, "") ?: ""
        return listString.split(SEPARATOR).mapNotNull(converter)
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: List<T>) {
        val listString = value.joinToString(SEPARATOR)
        sharedPrefs?.edit()?.apply {
            putString(property.name, listString)
            apply()
        }
    }

    companion object {
        private const val SEPARATOR = ","
    }
}
