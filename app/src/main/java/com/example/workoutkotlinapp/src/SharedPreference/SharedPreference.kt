package com.example.workoutkotlinapp.src.SharedPreference

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager(private val context: Context) {
    companion object {
        private const val TOKEN_KEY = "UserToken"
        private const val USER_ID_KEY = "UserId"
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

    fun updateUserId(userId: String?) {
        with(sharedPreferences.edit()) {
            putString(USER_ID_KEY, userId)
            apply()
        }
    }

    fun getUserId(): String? {
        return sharedPreferences.getString(USER_ID_KEY, null)
    }
}
