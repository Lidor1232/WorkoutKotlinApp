package com.example.workoutkotlinapp.src.screens.Login.components.SubmitButton

import androidx.lifecycle.viewModelScope
import com.example.workoutkotlinapp.ActiveScreen
import com.example.workoutkotlinapp.MainIntent
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.screens.Login.LoginViewModel
import kotlinx.coroutines.launch

class SubmitButtonController(
    private val mainViewModel: MainViewModel,
    private val loginViewModel: LoginViewModel,
) {
    fun onSubmit(
        userName: String?,
        password: String?,
    ) {
        loginViewModel.viewModelScope.launch {
            val response = loginViewModel.userLogin(userName!!, password!!)
            if (response != null) {
                mainViewModel.processIntent(MainIntent.SetToken(response.token))
                mainViewModel.processIntent(MainIntent.SetUser(response.user))
                mainViewModel.processIntent(MainIntent.SetActiveScreen(ActiveScreen.UserWorkouts))
            }
        }
    }
}
