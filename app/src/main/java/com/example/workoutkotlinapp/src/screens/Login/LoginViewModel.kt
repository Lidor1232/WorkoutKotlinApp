package com.example.workoutkotlinapp.src.screens.Login

import androidx.lifecycle.ViewModel
import com.example.workoutkotlinapp.src.Network.ApiClient
import com.example.workoutkotlinapp.src.Network.ApiService.routes.user.UserLoginRequest
import com.example.workoutkotlinapp.src.Network.ApiService.routes.user.UserLoginResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {
    private val _state = MutableStateFlow(LoginState())

    val state: StateFlow<LoginState> = _state

    fun processIntent(intent: LoginIntent) {
        when (intent) {
            is LoginIntent.SetUserName -> {
                _state.update {
                    it.copy(userName = intent.userName)
                }
            }

            is LoginIntent.SetPassword -> {
                _state.update {
                    it.copy(
                        password = intent.password,
                    )
                }
            }

            is LoginIntent.SetIsLoading -> {
                _state.update {
                    it.copy(
                        isLoading = intent.isLoading,
                    )
                }
            }

            is LoginIntent.SetError -> {
                _state.update {
                    it.copy(
                        error = intent.error,
                    )
                }
            }

            is LoginIntent.Reset -> {
                _state.update {
                    LoginState()
                }
            }
        }
    }

    suspend fun userLogin(
        userName: String,
        password: String,
    ): UserLoginResponse? {
        try {
            processIntent(LoginIntent.SetIsLoading(true))
            processIntent(LoginIntent.SetError(null))
            val body = UserLoginRequest(userName, password)
            val response = ApiClient.apiService(null).loginUser(body = body)
            processIntent(LoginIntent.SetIsLoading(false))
            return response
        } catch (e: retrofit2.HttpException) {
            processIntent(LoginIntent.SetIsLoading(false))
            processIntent(LoginIntent.SetError(e.message()))
            return null
        }
    }
}
