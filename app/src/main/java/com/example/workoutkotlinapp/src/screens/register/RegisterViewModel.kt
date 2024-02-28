package com.example.workoutkotlinapp.src.screens.register

import androidx.lifecycle.ViewModel
import com.example.workoutkotlinapp.src.network.ApiClient
import com.example.workoutkotlinapp.src.network.apiService.api.user.CreateUserRequest
import com.example.workoutkotlinapp.src.network.apiService.api.user.CreateUserResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class RegisterViewModel : ViewModel() {
    private val _state = MutableStateFlow(RegisterState())
    val state: StateFlow<RegisterState> = _state

    fun processIntent(intent: RegisterIntent) {
        when (intent) {
            is RegisterIntent.SetFirstName -> {
                _state.update {
                    it.copy(firstName = intent.firstName)
                }
            }

            is RegisterIntent.SetLastName -> {
                _state.update {
                    it.copy(lastName = intent.lastName)
                }
            }

            is RegisterIntent.SetUserName -> {
                _state.update {
                    it.copy(userName = intent.userName)
                }
            }

            is RegisterIntent.SetPassword -> {
                _state.update {
                    it.copy(password = intent.password)
                }
            }

            is RegisterIntent.SetIsLoading -> {
                _state.update {
                    it.copy(isLoading = intent.isLoading)
                }
            }

            is RegisterIntent.SetError -> {
                _state.update {
                    it.copy(error = intent.error)
                }
            }

            is RegisterIntent.Reset -> {
                _state.update {
                    RegisterState()
                }
            }
        }
    }

    suspend fun userRegister(
        firstName: String,
        lastName: String,
        userName: String,
        password: String,
    ): CreateUserResponse? {
        try {
            processIntent(RegisterIntent.SetIsLoading(true))
            processIntent(RegisterIntent.SetError(null))
            val body =
                CreateUserRequest(firstName, lastName, userName, password)
            val response = ApiClient.apiService(null).createUser(body = body)
            processIntent(RegisterIntent.SetIsLoading(false))
            return response
        } catch (e: retrofit2.HttpException) {
            processIntent(RegisterIntent.SetError(e.message()))
            processIntent(RegisterIntent.SetIsLoading(false))
            return null
        }
    }
}
