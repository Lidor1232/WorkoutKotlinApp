package com.example.workoutkotlinapp.src.screens.Login.components.PasswordInput

import com.example.workoutkotlinapp.src.screens.Login.LoginIntent
import com.example.workoutkotlinapp.src.screens.Login.LoginViewModel

class PasswordInputController(
    private val loginViewModel: LoginViewModel,
) {
    fun onPasswordInputChange(text: String) {
        loginViewModel.processIntent(LoginIntent.SetPassword(text))
    }
}
