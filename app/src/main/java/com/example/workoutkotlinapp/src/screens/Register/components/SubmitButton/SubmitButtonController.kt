package com.example.workoutkotlinapp.src.screens.Register.components.SubmitButton

import androidx.lifecycle.viewModelScope
import com.example.workoutkotlinapp.ActiveScreen
import com.example.workoutkotlinapp.MainIntent
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.screens.Register.RegisterViewModel
import kotlinx.coroutines.launch
import timber.log.Timber

class SubmitButtonController(
    private val registerViewModel: RegisterViewModel,
    private val mainViewModel: MainViewModel,
) {
    fun onClick(
        firstName: String,
        lastName: String,
        userName: String,
        password: String,
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
                mainViewModel.processIntent(MainIntent.SetUser(response.user))
                mainViewModel.processIntent(MainIntent.SetActiveScreen(ActiveScreen.UserWorkouts))
                Timber.d("Register User: $response")
            }
        }
    }
}
