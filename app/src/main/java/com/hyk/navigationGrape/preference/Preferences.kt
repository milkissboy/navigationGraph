package com.hyk.navigationGrape.preference

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

object Preferences {

    private lateinit var preferences: SharedPreferences

    private const val IS_FIRST: String = "isFirst"

    private const val IS_SIGNED: String = "isSigned"

    fun Application.preferencesInit() {
        preferences = applicationContext.getSharedPreferences("myApp", Context.MODE_PRIVATE)
    }

    private fun putAny(name: String, any: Any) {
        when (any) {
            is String -> preferences.edit().putString(name, any).apply()
            is Int -> preferences.edit().putInt(name, any).apply()
            is Boolean -> preferences.edit().putBoolean(name, any).apply()
            is Float -> preferences.edit().putFloat(name, any).apply()
            is Long -> preferences.edit().putLong(name, any).apply()
        }
    }

    // 처음 실행 여부
    var isFirst
        get() = preferences.getBoolean(IS_FIRST, true)
        set(value) {
            putAny(IS_FIRST, value)
        }

    // 로그인 여부
    var isSignedIn
        get() = preferences.getBoolean(IS_SIGNED, false)
        set(value) {
            putAny(IS_SIGNED, value)
        }

    /*var id
        get() = preferences.getLong(ID, 0)
        private set(value) {
            putAny(ID, value)
        }

    // phone number
    var userId
        get() = preferences.getString(USER_ID, String.empty) ?: String.empty
        private set(value) {
            putAny(USER_ID, value)
        }*/
}