package com.bottlerocketstudios.launchpad.utils.sharedpref

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class MapPreferenceDelegate(private val sharedPrefs: SharedPreferences?) : ReadWriteProperty<Any, Map<String, String> > {
    override fun getValue(thisRef: Any, property: KProperty<*>): Map<String, String> {
        val hashMapStr = sharedPrefs?.getString(property.name, "")
        return if (hashMapStr != null) {
            if (hashMapStr.isNotEmpty()) {
                val hashMap = hashMapStr.split(",").associate {
                    val (left, right) = it.split("=")
                    left to right
                }
                hashMap
            } else {
                HashMap()
            }
        } else {
            HashMap()
        }
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Map<String, String>) {
        val updatedHashMap = value.toString()
            .replace("{", "")
            .replace("}", "")
            .replace(" ", "")
        sharedPrefs?.edit()?.apply {
            putString(property.name, updatedHashMap)
            apply()
        }
    }
}