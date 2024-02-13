package com.example.workoutkotlinapp.src.screens.Login.components.ErrorHandler

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.Login.LoginState
import com.example.workoutkotlinapp.src.screens.Login.LoginViewModel

@Composable
fun ErrorHandler() {
    val viewModel: LoginViewModel = viewModel()
    val state by viewModel.state.observeAsState(LoginState())

    if (state.error != null) {
        Text(
            text = "${state.error}",
            modifier = Modifier.padding(bottom = 16.dp),
            color = Color.Red,
        )
    }
}
