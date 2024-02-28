package com.example.workoutkotlinapp.src.screens.register.components.passwordInput

import com.example.workoutkotlinapp.src.screens.register.RegisterIntent
import com.example.workoutkotlinapp.src.screens.register.RegisterViewModel

class PasswordInputController(
    private val registerViewModel: RegisterViewModel,
) {
    fun onPasswordInputChange(text: String) {
        registerViewModel.processIntent(RegisterIntent.SetPassword(text))
    }
}
