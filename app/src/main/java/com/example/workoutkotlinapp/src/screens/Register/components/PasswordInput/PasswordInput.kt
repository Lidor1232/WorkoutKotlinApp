package com.example.workoutkotlinapp.src.screens.Register.components.PasswordInput

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.Register.RegisterViewModel
import kotlinx.coroutines.flow.map

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInput() {
    val registerViewModel: RegisterViewModel = viewModel()

    val passwordInputController = PasswordInputController(registerViewModel)

    val password by registerViewModel.state.map { it.password }.collectAsState(initial = "")

    TextField(
        modifier = Modifier.padding(bottom = 16.dp),
        value = password,
        onValueChange = {
                text ->
            passwordInputController.onPasswordInputChange(text)
        },
        placeholder = {
            Text("Password")
        },
    )
}
