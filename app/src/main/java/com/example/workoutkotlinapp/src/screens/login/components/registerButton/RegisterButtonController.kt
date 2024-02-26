package com.example.workoutkotlinapp.src.screens.login.components.registerButton

import com.example.workoutkotlinapp.ActiveScreen
import com.example.workoutkotlinapp.MainIntent
import com.example.workoutkotlinapp.MainViewModel

class RegisterButtonController(
    private val mainViewModel: MainViewModel,
) {
    fun onClick() {
        mainViewModel.processIntent(MainIntent.SetActiveScreen(ActiveScreen.Register))
    }
}
