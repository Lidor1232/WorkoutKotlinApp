package com.example.workoutkotlinapp.src.screens.register.components.userNameInput

import com.example.workoutkotlinapp.src.screens.register.RegisterIntent
import com.example.workoutkotlinapp.src.screens.register.RegisterViewModel

class UserNameInputController(
    private val registerViewModel: RegisterViewModel,
) {
    fun onUserNameInputChange(text: String) {
        registerViewModel.processIntent(RegisterIntent.SetUserName(text))
    }
}
