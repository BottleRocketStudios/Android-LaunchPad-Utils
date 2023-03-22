package com.bottlerocketstudios.launchpad.utils.sharedpref

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.bottlerocketstudios.launchpad.utils.domain.sharedpref.PreferencesInterface
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/** Example of a how to use the Preference delegates. */
class SecurePreferencesImpl : PreferencesInterface, KoinComponent {

    private val context: Context by inject()

    // Filename for secure preferences
    companion object {
        private const val EncryptedSharedPreferencesFilename = "encrypted_shared_prefs"
    }

    // Master key
    private val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

    // Preferences holder
    private val encryptedSharedPreferences = EncryptedSharedPreferences.create(
        EncryptedSharedPreferencesFilename, masterKeyAlias, context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    override var boolVar: Boolean by BooleanPreferenceDelegate(encryptedSharedPreferences)
    override var stringVar: String by StringPreferenceDelegate(encryptedSharedPreferences)
    override var listVar: List<Int> by ListPreferenceDelegate(encryptedSharedPreferences, String::toIntOrNull)
    override var mapVar: Map<String, String> by MapPreferenceDelegate(encryptedSharedPreferences)
    override var intVar: Int by IntPreferenceDelegate(encryptedSharedPreferences)
    override var floatVar: Float by FloatPreferenceDelegate(encryptedSharedPreferences)
    override var longVar: Long by LongPreferenceDelegate(encryptedSharedPreferences)
    override var stringSetVar: Set<String> by StringSetPreferenceDelegate(encryptedSharedPreferences)
}