package com.aakash.spikecmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform