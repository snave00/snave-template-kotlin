package com.example.evansontemplate.common

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.securepreferences.SecurePreferences

object LocalStorage {
    // Installation
    private const val KEY_IS_FRESH_INSTALLED = "LocalStorage.KEY_IS_FRESH_INSTALLED"

    // Temp data
    private const val KEY_PREVIOUS_ACTIVITY = "LocalStorage.KEY_PREVIOUS_ACTIVITY"

    private lateinit var sharedPref: SecurePreferences

    fun init(context: Context) {
        sharedPref = SecurePreferences(context)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    // Installation
    var isFreshInstalled: Boolean
        get() = sharedPref.getBoolean(KEY_IS_FRESH_INSTALLED, true)
        set(value) {
            sharedPref.edit { it.putBoolean(KEY_IS_FRESH_INSTALLED, value) }
        }

    // Temp data
    var previousActivity: String
        get() = sharedPref.getString(KEY_PREVIOUS_ACTIVITY, "") ?: ""
        set(value) {
            sharedPref.edit { it.putString(KEY_PREVIOUS_ACTIVITY, value.trim()) }
        }
}