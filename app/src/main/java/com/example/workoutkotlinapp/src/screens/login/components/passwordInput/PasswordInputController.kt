package com.example.workoutkotlinapp.src.screens.login.components.passwordInput

import com.example.workoutkotlinapp.src.screens.login.LoginIntent
import com.example.workoutkotlinapp.src.screens.login.LoginViewModel

class PasswordInputController(
    private val loginViewModel: LoginViewModel,
) {
    fun onPasswordInputChange(text: String) {
        loginViewModel.processIntent(LoginIntent.SetPassword(text))
    }
}
