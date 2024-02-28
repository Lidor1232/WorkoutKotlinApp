package com.example.workoutkotlinapp.src.screens.register.components.loginButton

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.MainViewModel

@Composable
fun LoginButton() {
    val mainViewModel: MainViewModel = viewModel()

    val loginButtonController = LoginButtonController(mainViewModel)

    Button(onClick = {
        loginButtonController.onClick()
    }) {
        Text(text = "Login")
    }
}
