package com.example.workoutkotlinapp.src.DataStore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "user_preferences")

class DataStoreManager(private val context: Context) {
    companion object {
        private val KEY_AUTH_TOKEN = stringPreferencesKey("auth_token")
    }

    suspend fun saveAuthToken(token: String) {
        context.dataStore.edit { preferences ->
            preferences[KEY_AUTH_TOKEN] = token
        }
    }

    fun getAuthToken(): Flow<String?> {
        return context.dataStore.data
            .map { preferences ->
                preferences[KEY_AUTH_TOKEN]
            }
    }
}
