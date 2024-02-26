package com.example.workoutkotlinapp.src.screens.Register.components.loginButton

import com.example.workoutkotlinapp.ActiveScreen
import com.example.workoutkotlinapp.MainIntent
import com.example.workoutkotlinapp.MainViewModel

class LoginButtonController(
    private val mainViewModel: MainViewModel,
) {
    fun onClick() {
        mainViewModel.processIntent(MainIntent.SetActiveScreen(ActiveScreen.Login))
    }
}
