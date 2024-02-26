package com.example.workoutkotlinapp.src.screens.Register.components.submitButton

import androidx.lifecycle.viewModelScope
import com.example.workoutkotlinapp.ActiveScreen
import com.example.workoutkotlinapp.MainIntent
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.screens.Register.RegisterViewModel
import com.example.workoutkotlinapp.src.sharedPreference.SharedPreferencesManager
import kotlinx.coroutines.launch

class SubmitButtonController(
    private val registerViewModel: RegisterViewModel,
    private val mainViewModel: MainViewModel,
) {
    fun onClick(
        firstName: String,
        lastName: String,
        userName: String,
        password: String,
        sharedPreferencesManager: SharedPreferencesManager,
    ) {
        registerViewModel.viewModelScope.launch {
            val response =
                registerViewModel.userRegister(
                    firstName,
                    lastName,
                    userName,
                    password,
                )
            if (response != null) {
                mainViewModel.processIntent(MainIntent.SetToken(response.token))
                mainViewModel.processIntent(MainIntent.GetUserSetUser(response.user))
                mainViewModel.processIntent(MainIntent.SetActiveScreen(ActiveScreen.UserWorkouts))
                sharedPreferencesManager.updateToken(response.token)
            }
        }
    }
}
