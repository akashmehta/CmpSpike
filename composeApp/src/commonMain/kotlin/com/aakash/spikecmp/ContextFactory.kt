package com.aakash.spikecmp

expect class ContextFactory {
    fun getContext(): Any?
    fun getApplication(): Any?
    fun getActivity(): Any?
}