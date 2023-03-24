package com.bottlerocketstudios.launchpad.utils.sharedpref

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class IntPreferenceDelegate(private val sharedPreferences: SharedPreferences?) :
    ReadWriteProperty<Any, Int> {
    override fun getValue(thisRef: Any, property: KProperty<*>) = sharedPreferences?.getInt(property.name, 0) ?: 0

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Int) {
        sharedPreferences?.edit()?.apply {
            putInt(property.name, value)
            apply()
        }
    }
}
