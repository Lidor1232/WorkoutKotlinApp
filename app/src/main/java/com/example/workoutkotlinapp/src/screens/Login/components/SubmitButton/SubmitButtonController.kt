package com.example.workoutkotlinapp.src.screens.Login.components.SubmitButton

import androidx.lifecycle.viewModelScope
import com.example.workoutkotlinapp.ActiveScreen
import com.example.workoutkotlinapp.MainIntent
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.SharedPreference.SharedPreferencesManager
import com.example.workoutkotlinapp.src.screens.Login.LoginViewModel
import kotlinx.coroutines.launch

class SubmitButtonController(
    private val mainViewModel: MainViewModel,
    private val loginViewModel: LoginViewModel,
) {
    fun onSubmit(
        userName: String,
        password: String,
        sharedPreferencesManager: SharedPreferencesManager,
    ) {
        loginViewModel.viewModelScope.launch {
            val response = loginViewModel.userLogin(userName, password)
            if (response != null) {
                mainViewModel.processIntent(MainIntent.SetToken(response.token))
                mainViewModel.processIntent(MainIntent.GetUserSetUser(response.user))
                mainViewModel.processIntent(MainIntent.SetActiveScreen(ActiveScreen.UserWorkouts))
                sharedPreferencesManager.updateToken(response.token)
            }
        }
    }
}
