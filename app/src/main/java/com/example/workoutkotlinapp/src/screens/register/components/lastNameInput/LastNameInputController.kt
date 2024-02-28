package com.example.workoutkotlinapp.src.screens.register.components.lastNameInput

import com.example.workoutkotlinapp.src.screens.register.RegisterIntent
import com.example.workoutkotlinapp.src.screens.register.RegisterViewModel

class LastNameInputController(
    private val registerViewModel: RegisterViewModel,
) {
    fun onChangeLastNameInput(text: String) {
        registerViewModel.processIntent(RegisterIntent.SetLastName(text))
    }
}
