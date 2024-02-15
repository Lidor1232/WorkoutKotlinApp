package com.example.workoutkotlinapp.src.screens.Login.components.PasswordInput

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.Login.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInput() {
    val loginViewModel: LoginViewModel = viewModel()

    val passwordInputController =
        PasswordInputController(
            loginViewModel,
        )

    val password by loginViewModel.state.map { it.password }.observeAsState()

    if (password !== null) {
        TextField(
            modifier = Modifier.padding(bottom = 16.dp),
            value = password!!,
            onValueChange = {
                    text ->
                passwordInputController.onPasswordInputChange(text)
            },
            placeholder = {
                Text("Password")
            },
        )
    }
}
