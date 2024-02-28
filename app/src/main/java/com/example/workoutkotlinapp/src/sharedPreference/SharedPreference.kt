package com.example.workoutkotlinapp.src.sharedPreference

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager(private val context: Context) {
    companion object {
        private const val TOKEN_KEY = "UserToken"
    }

    private val sharedPreferences: SharedPreferences get() = context.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)

    fun updateToken(token: String?) {
        with(sharedPreferences.edit()) {
            putString(TOKEN_KEY, token)
            apply()
        }
    }

    fun getToken(): String? {
        return sharedPreferences.getString(TOKEN_KEY, null)
    }
}
