package com.example.workoutkotlinapp.src.screens.Login.components.UserNameInput

import com.example.workoutkotlinapp.src.screens.Login.LoginIntent
import com.example.workoutkotlinapp.src.screens.Login.LoginViewModel

class UserNameInputController(
    private val loginViewModel: LoginViewModel,
) {
    fun onChangeUserNameInput(text: String) {
        loginViewModel.processIntent(LoginIntent.SetUserName(text))
    }
}
