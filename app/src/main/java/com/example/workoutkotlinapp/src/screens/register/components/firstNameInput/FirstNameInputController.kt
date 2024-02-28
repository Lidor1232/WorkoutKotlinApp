package com.example.workoutkotlinapp.src.screens.register.components.firstNameInput

import com.example.workoutkotlinapp.src.screens.register.RegisterIntent
import com.example.workoutkotlinapp.src.screens.register.RegisterViewModel

class FirstNameInputController(
    private val registerViewModel: RegisterViewModel,
) {
    fun onChangeFirstNameInput(text: String) {
        registerViewModel.processIntent(RegisterIntent.SetFirstName(text))
    }
}
