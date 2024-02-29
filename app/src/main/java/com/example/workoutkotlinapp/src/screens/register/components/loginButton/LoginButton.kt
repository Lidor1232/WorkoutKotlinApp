package com.example.workoutkotlinapp.src.screens.register.components.loginButton

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.R

@Composable
fun LoginButton() {
    val mainViewModel: MainViewModel = viewModel()

    val loginButtonController = LoginButtonController(mainViewModel)

    Button(onClick = {
        loginButtonController.onClick()
    }) {
        Text(text = stringResource(R.string.register_login_button))
    }
}
