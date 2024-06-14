package com.example.englishtraining

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

class SecurePreferencesHelper(context: Context) {
    private val masterKeyAlias = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val sharedPreferences = EncryptedSharedPreferences.create(
        context,
        "secure_prefs",
        masterKeyAlias,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    fun saveUserId(userId: Int) {
        sharedPreferences.edit().putInt("user_id", userId).apply()
    }

    fun getUserId(): Int {
        return sharedPreferences.getInt("user_id", -1) // Return -1 if user ID is not found
    }

    fun clearUserId() {
        sharedPreferences.edit().remove("user_id").apply()
    }
}