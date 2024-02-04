package com.example.workoutkotlinapp.src.screens.Login

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Login() {
    val viewModel: LoginViewModel = viewModel()
    val state by viewModel.state.observeAsState(LoginState())

    Text(text = "Hello Login ${state.userName}")
}
