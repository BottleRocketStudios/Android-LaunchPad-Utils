package com.bottlerocketstudios.launchpad.utils

import android.content.Context
import androidx.annotation.StringRes
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * This use this to do any String transformations, etc. Intended for DI in order to retrieve String resources in non-contextual classes.
 */
object StringHelper : KoinComponent {
    private val context: Context by inject()
    fun getStringFromResource(@StringRes resourceId: Int) = context.getString(resourceId)
}
