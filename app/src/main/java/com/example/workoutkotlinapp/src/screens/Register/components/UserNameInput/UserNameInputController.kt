package com.example.workoutkotlinapp.src.screens.Register.components.UserNameInput

import com.example.workoutkotlinapp.src.screens.Register.RegisterIntent
import com.example.workoutkotlinapp.src.screens.Register.RegisterViewModel

class UserNameInputController(
    private val registerViewModel: RegisterViewModel,
) {
    fun onUserNameInputChange(text: String) {
        registerViewModel.processIntent(RegisterIntent.SetUserName(text))
    }
}
