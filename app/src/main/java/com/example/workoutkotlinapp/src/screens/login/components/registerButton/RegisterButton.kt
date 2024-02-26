package com.example.workoutkotlinapp.src.screens.login.components.registerButton

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.MainViewModel

@Composable
fun RegisterButton() {
    val mainViewModel: MainViewModel = viewModel()

    val registerButtonController = RegisterButtonController(mainViewModel)

    Button(onClick = {
        registerButtonController.onClick()
    }) {
        Text(text = "Register")
    }
}
