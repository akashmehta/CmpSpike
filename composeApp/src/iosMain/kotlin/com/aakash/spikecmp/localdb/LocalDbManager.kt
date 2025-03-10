package com.aakash.spikecmp.localdb

import com.aakash.spikecmp.ContextFactory
import platform.Foundation.NSUserDefaults

actual class LocalDbManager actual constructor(contextFactory: ContextFactory) {
    // Reference to NSUserDefaults
    private val defaults: NSUserDefaults = NSUserDefaults.standardUserDefaults()
    // MutableStateFlow to observe changes
    // Save a boolean value in NSUserDefaults
    actual fun saveBooleanSetting(key: String, value: Boolean) {
        defaults.setBool(value, key)
    }
    // Retrieve a boolean value from NSUserDefaults as Flow
    actual fun getBooleanSetting(key: String): String {
        val value = defaults.boolForKey(key).takeIf { defaults.objectForKey(key) != null } ?: false
        return "Retrieving variable: $key: $value"
    }
}