package com.example.workoutkotlinapp.src.screens.Login.components.LoadingHandler

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.Login.LoginState
import com.example.workoutkotlinapp.src.screens.Login.LoginViewModel

@Composable()
fun LoadingHandler() {
    val viewModel: LoginViewModel = viewModel()
    val state by viewModel.state.observeAsState(LoginState())

    if (state.isLoading) {
        Text(
            text = "Loading...",
            modifier = Modifier.padding(bottom = 16.dp),
        )
    }
}
