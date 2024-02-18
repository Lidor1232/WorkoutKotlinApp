package com.example.workoutkotlinapp.src.screens.Login.components.SubmitButton

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.SharedPreference.SharedPreferencesManager
import com.example.workoutkotlinapp.src.screens.Login.LoginViewModel
import kotlinx.coroutines.flow.map

@Composable
fun SubmitButton() {
    val context = LocalContext.current
    val sharedPreferencesManager = SharedPreferencesManager(context)

    val loginViewModel: LoginViewModel = viewModel()
    val mainViewModel: MainViewModel = viewModel()

    val submitButtonController =
        SubmitButtonController(
            mainViewModel,
            loginViewModel,
        )

    val userName by loginViewModel.state.map { it.userName }.collectAsState(initial = "")
    val password by loginViewModel.state.map { it.password }.collectAsState(initial = "")

    Button(
        modifier = Modifier.padding(bottom = 16.dp),
        onClick = {
            submitButtonController.onSubmit(userName, password, sharedPreferencesManager)
        },
    ) {
        Text(text = "Submit")
    }
}
