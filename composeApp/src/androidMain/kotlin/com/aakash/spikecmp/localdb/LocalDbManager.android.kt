package com.aakash.spikecmp.localdb

import android.content.Context
import android.content.SharedPreferences
import com.aakash.spikecmp.ContextFactory

actual class LocalDbManager actual constructor(contextFactory: ContextFactory) {
    private val sharedPrefs = (contextFactory.getContext() as Context).getSharedPreferences(
        "app_prefs", Context.MODE_PRIVATE)

    actual fun saveBooleanSetting(key: String, value: Boolean) {
        sharedPrefs.edit().putBoolean(key, value).apply()
    }

    actual fun getBooleanSetting(key: String): String {
        val value = sharedPrefs.getBoolean(key, false)
        return "Retrieving variable: $key : $value"
    }
}