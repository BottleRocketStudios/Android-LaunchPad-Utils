package com.bottlerocketstudios.launchpad.utils.analytics

import android.os.Bundle

interface AnalyticsInterface {
    fun resetAnalyticsData()
    fun setUserProperty(propertyName: String, value: String)
    fun logEvent(eventName: String, params: Bundle?) //TODO - how to make these last 2 functions more generic rather than echoing Firebase's impl in particular?
}