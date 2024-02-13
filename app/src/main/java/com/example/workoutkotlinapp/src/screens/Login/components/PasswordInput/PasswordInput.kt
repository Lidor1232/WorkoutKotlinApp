package com.example.workoutkotlinapp.src.screens.Login.components.PasswordInput

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.Login.LoginIntent
import com.example.workoutkotlinapp.src.screens.Login.LoginState
import com.example.workoutkotlinapp.src.screens.Login.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInput() {
    val viewModel: LoginViewModel = viewModel()
    val state by viewModel.state.observeAsState(LoginState())

    TextField(value = state.password, onValueChange = {
            text ->
        viewModel.processIntent(LoginIntent.SetPassword(text))
    }, modifier = Modifier.padding(bottom = 16.dp))
}
