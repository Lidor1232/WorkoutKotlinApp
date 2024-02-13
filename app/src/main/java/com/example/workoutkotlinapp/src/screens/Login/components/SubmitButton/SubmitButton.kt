package com.example.workoutkotlinapp.src.screens.Login.components.SubmitButton

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.ActiveScreen
import com.example.workoutkotlinapp.MainIntent
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.screens.Login.LoginState
import com.example.workoutkotlinapp.src.screens.Login.LoginViewModel
import kotlinx.coroutines.launch

@Composable
fun SubmitButton() {
    val loginViewModel: LoginViewModel = viewModel()
    val mainViewModel: MainViewModel = viewModel()
    val state by loginViewModel.state.observeAsState(LoginState())

    Button(onClick = {
        loginViewModel.viewModelScope.launch {
            val response = loginViewModel.userLogin(state.userName, state.password)
            if (response != null) {
                mainViewModel.processIntent(MainIntent.SetToken(response.token))
                mainViewModel.processIntent(MainIntent.SetUser(response.user))
                mainViewModel.processIntent(MainIntent.SetActiveScreen(ActiveScreen.UserWorkouts))
            }
        }
    }, modifier = Modifier.padding(bottom = 16.dp)) {
        Text(text = "Submit")
    }
}
