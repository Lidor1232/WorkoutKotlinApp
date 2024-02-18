package com.example.workoutkotlinapp.src.screens.UserWorkouts.components.LogoutButton

import com.example.workoutkotlinapp.ActiveScreen
import com.example.workoutkotlinapp.MainIntent
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.SharedPreference.SharedPreferencesManager

class LogoutButtonController(
    private val mainViewModel: MainViewModel,
    private val sharedPreferencesManager: SharedPreferencesManager,
) {
    fun onClick() {
        sharedPreferencesManager.updateToken(null)
        mainViewModel.processIntent(MainIntent.SetToken(null))
        mainViewModel.processIntent(MainIntent.GetUserSetUser(null))
        mainViewModel.processIntent(MainIntent.SetActiveScreen(ActiveScreen.Login))
    }
}
