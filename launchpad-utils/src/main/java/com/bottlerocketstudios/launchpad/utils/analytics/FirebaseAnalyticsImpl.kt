package com.bottlerocketstudios.launchpad.utils.analytics

import android.content.Context
import android.os.Bundle
import com.google.android.gms.tasks.Task
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.FirebaseAnalytics.ConsentStatus
import com.google.firebase.analytics.FirebaseAnalytics.ConsentType
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class FirebaseAnalyticsImpl : FirebaseAnalyticsInterface, KoinComponent {

    private val context: Context by inject()
    private val analytics: FirebaseAnalytics by lazy {
        FirebaseAnalytics.getInstance(context)
    }

    override val appInstanceId: Task<String?>
        get() = analytics.appInstanceId

    override val sessionId: Task<Long?>
        get() = analytics.sessionId

    override val firebaseInstanceId: String
        get() = analytics.firebaseInstanceId

    override fun resetAnalyticsData() = analytics.resetAnalyticsData()

    override fun setUserProperty(propertyName: String, value: String) =
        analytics.setUserProperty(propertyName, value)

    override fun logEvent(eventName: String, params: Bundle?) =
        analytics.logEvent(eventName, params)

    override fun setDefaultEventParams(params: Bundle?) = analytics.setDefaultEventParameters(params)

    override fun setFirebaseConsent(consentMap: Map<ConsentType, ConsentStatus>) = analytics.setConsent(consentMap)

    override fun setAnalyticsCollectionEnabled(enabled: Boolean) = analytics.setAnalyticsCollectionEnabled(enabled)

    override fun setUserId(id: String) = analytics.setUserId(id)
}