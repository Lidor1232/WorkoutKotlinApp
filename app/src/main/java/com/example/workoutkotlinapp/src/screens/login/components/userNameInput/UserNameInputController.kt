package com.example.workoutkotlinapp.src.screens.login.components.userNameInput

import com.example.workoutkotlinapp.src.screens.login.LoginIntent
import com.example.workoutkotlinapp.src.screens.login.LoginViewModel

class UserNameInputController(
    private val loginViewModel: LoginViewModel,
) {
    fun onChangeUserNameInput(text: String) {
        loginViewModel.processIntent(LoginIntent.SetUserName(text))
    }
}
