package com.example.workoutkotlinapp.src.screens.Register.components.LoginButton

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.ActiveScreen
import com.example.workoutkotlinapp.MainIntent
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