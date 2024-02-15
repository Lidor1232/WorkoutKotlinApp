package com.example.workoutkotlinapp.src.screens.Register.components.PasswordInput

import com.example.workoutkotlinapp.src.screens.Register.RegisterIntent
import com.example.workoutkotlinapp.src.screens.Register.RegisterViewModel

class PasswordInputController(
    private val registerViewModel: RegisterViewModel,
) {
    fun onPasswordInputChange(text: String) {
        registerViewModel.processIntent(RegisterIntent.SetPassword(text))
    }
}
