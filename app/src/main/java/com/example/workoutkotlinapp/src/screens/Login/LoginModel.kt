package com.example.workoutkotlinapp.src.screens.Login

data class LoginState(val userName: String = "", val password: String = "")

sealed class LoginIntent {
    data class SetUserName(val userName: String) : LoginIntent()

    data class SetPassword(val password: String) : LoginIntent()
}
