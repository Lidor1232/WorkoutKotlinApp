package com.example.workoutkotlinapp.src.screens.login.components.registerButton

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.R

@Composable
fun RegisterButton() {
    val mainViewModel: MainViewModel = viewModel()

    val registerButtonController = RegisterButtonController(mainViewModel)

    Button(onClick = {
        registerButtonController.onClick()
    }) {
        Text(text = stringResource(R.string.login_register_button),)
    }
}
