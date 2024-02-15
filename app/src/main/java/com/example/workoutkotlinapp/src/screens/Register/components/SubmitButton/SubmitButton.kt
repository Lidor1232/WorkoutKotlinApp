package com.example.workoutkotlinapp.src.screens.Register.components.SubmitButton

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
import com.example.workoutkotlinapp.src.screens.Register.RegisterState
import com.example.workoutkotlinapp.src.screens.Register.RegisterViewModel
import kotlinx.coroutines.launch
import timber.log.Timber

@Composable
fun SubmitButton() {
    val registerViewModel: RegisterViewModel = viewModel()
    val mainViewModel: MainViewModel = viewModel()
    val state by registerViewModel.state.observeAsState(RegisterState())

    Button(onClick = {
        registerViewModel.viewModelScope.launch {
            val response =
                registerViewModel.userRegister(
                    state.firstName,
                    state.lastName,
                    state.userName,
                    state.password,
                )
            if (response != null) {
                mainViewModel.processIntent(MainIntent.SetToken(response.token))
                mainViewModel.processIntent(MainIntent.SetUser(response.user))
                mainViewModel.processIntent(MainIntent.SetActiveScreen(ActiveScreen.UserWorkouts))
                Timber.d("Register User: $response")
            }
        }
    }, modifier = Modifier.padding(bottom = 16.dp)) {
        Text(text = "Submit")
    }
}
