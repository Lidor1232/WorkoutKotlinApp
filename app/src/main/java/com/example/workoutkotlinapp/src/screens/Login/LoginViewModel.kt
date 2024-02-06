package com.example.workoutkotlinapp.src.screens.Login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.workoutkotlinapp.src.Network.ApiClient
import com.example.workoutkotlinapp.src.Network.ApiService.routes.user.UserLoginRequest
import timber.log.Timber

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
        }
    }

    suspend fun userLogin(
        userName: String,
        password: String,
    ) {
        val body = UserLoginRequest(userName, password)
        val response = ApiClient.apiService.loginUser(body = body)

        Timber.d("RESPONSE: ${response.user.userName}")
    }
}
