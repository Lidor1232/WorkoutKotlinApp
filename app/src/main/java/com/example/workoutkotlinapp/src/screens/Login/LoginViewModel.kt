package com.example.workoutkotlinapp.src.screens.Login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.workoutkotlinapp.src.Network.ApiClient
import com.example.workoutkotlinapp.src.Network.ApiService.routes.user.UserLoginRequest
import com.example.workoutkotlinapp.src.Network.ApiService.routes.user.UserLoginResponse

class LoginViewModel : ViewModel() {
    private val _state = MutableLiveData(LoginState())
    val state: LiveData<LoginState> get() = _state

    fun processIntent(intent: LoginIntent) {
        when (intent) {
            is LoginIntent.SetUserName -> {
                _state.value = _state.value?.copy(userName = intent.userName)
            }

            is LoginIntent.SetPassword -> {
                _state.value = _state.value?.copy(password = intent.password)
            }

            is LoginIntent.SetIsLoading -> {
                _state.value = _state.value?.copy(isLoading = intent.isLoading)
            }

            is LoginIntent.SetError -> {
                _state.value = _state.value?.copy(error = intent.error)
            }

            is LoginIntent.Reset -> {
                _state.value = LoginState()
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
