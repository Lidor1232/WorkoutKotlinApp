package com.example.workoutkotlinapp.src.screens.Login

data class LoginState(val userName: String = "", val password: String = "", val isLoading: Boolean = false, val error: String? = null)

sealed class LoginIntent {
    data class SetUserName(val userName: String) : LoginIntent()

    data class SetPassword(val password: String) : LoginIntent()

    data class SetIsLoading(val isLoading: Boolean) : LoginIntent()

    data class SetError(val error: String?) : LoginIntent()
}
