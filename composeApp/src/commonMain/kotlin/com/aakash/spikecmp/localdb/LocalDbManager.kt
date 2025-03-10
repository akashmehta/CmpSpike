package com.aakash.spikecmp.localdb

import com.aakash.spikecmp.ContextFactory

expect class LocalDbManager(contextFactory: ContextFactory) {
    fun saveBooleanSetting(key: String, value: Boolean)
    fun getBooleanSetting(key: String): String
}