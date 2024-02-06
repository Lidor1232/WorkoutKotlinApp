package com.example.workoutkotlinapp.src.screens.Register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {
    private val _state = MutableLiveData(RegisterState())
    val state: LiveData<RegisterState> get() = _state

    fun processIntent(intent: RegisterIntent) {
        when (intent) {
            is RegisterIntent.SetFirstName -> {
                _state.value = _state.value?.copy(firstName = intent.firstName)
            }

            is RegisterIntent.SetLastName -> {
                _state.value = _state.value?.copy(lastName = intent.lastName)
            }

            is RegisterIntent.SetUserName -> {
                _state.value = _state.value?.copy(userName = intent.userName)
            }

            is RegisterIntent.SetPassword -> {
                _state.value = _state.value?.copy(password = intent.password)
            }

            is RegisterIntent.SetIsLoading -> {
                _state.value = _state.value?.copy(isLoading = intent.isLoading)
            }

            is RegisterIntent.SetError -> {
                _state.value = _state.value?.copy(error = intent.error)
            }
        }
    }

    suspend fun userRegister(
        firstName: String,
        lastName: String,
        userName: String,
        password: String,
    ) {
        try {
            processIntent(RegisterIntent.SetIsLoading(true))
            processIntent(RegisterIntent.SetError(null))
        } catch (e: retrofit2.HttpException) {
        }
    }
}
