package com.example.workoutkotlinapp

import androidx.lifecycle.ViewModel
import com.example.workoutkotlinapp.src.network.ApiClient
import com.example.workoutkotlinapp.src.sharedPreference.SharedPreferencesManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {
    private val _state = MutableStateFlow(MainState())
    val state: StateFlow<MainState> = _state

    fun processIntent(intent: MainIntent) {
        when (intent) {
            is MainIntent.GetUserSetUser -> {
                val newGetUser = _state.value?.getUser?.copy(user = intent.user)
                if (newGetUser !== null) {
                    _state.update {
                        it.copy(getUser = newGetUser)
                    }
                }
            }
            is MainIntent.GetUserSetIsLoading -> {
                val newGetUser = _state.value?.getUser?.copy(isLoading = intent.isLoading)
                if (newGetUser !== null) {
                    _state.update {
                        it.copy(getUser = newGetUser)
                    }
                }
            }
            is MainIntent.GetUserSetError -> {
                val newGetUser = _state.value?.getUser?.copy(error = intent.error)
                if (newGetUser !== null) {
                    _state.update {
                        it.copy(
                            getUser = newGetUser,
                        )
                    }
                }
            }
            is MainIntent.SetActiveScreen -> {
                _state.update {
                    it.copy(activeScreen = intent.activeScreen)
                }
            }
            is MainIntent.SetToken -> {
                _state.update {
                    it.copy(token = intent.token)
                }
            }
        }
    }

    private suspend fun getUser(token: String) {
        try {
            processIntent(MainIntent.GetUserSetIsLoading(true))
            processIntent(MainIntent.GetUserSetError(null))
            val user = ApiClient.apiService(token).getUser()
            processIntent(MainIntent.GetUserSetIsLoading(false))
            processIntent(MainIntent.GetUserSetUser(user))
        } catch (e: retrofit2.HttpException) {
            processIntent(MainIntent.GetUserSetIsLoading(false))
            processIntent(MainIntent.GetUserSetError(e.message))
        }
    }

    suspend fun handleLocalToken(sharedPreferencesManager: SharedPreferencesManager) {
        val token = sharedPreferencesManager.getToken()
        if (token !== null) {
            processIntent(MainIntent.SetToken(token))
            getUser(token)
            processIntent(MainIntent.SetActiveScreen(ActiveScreen.UserWorkouts))
        } else {
            processIntent(MainIntent.SetActiveScreen(ActiveScreen.Login))
        }
    }
}
