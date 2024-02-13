package com.example.workoutkotlinapp.src.screens.Login.components.LoadingHandler

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.Login.LoginViewModel

@Composable()
fun LoadingHandler() {
    val viewModel: LoginViewModel = viewModel()

    val isLoading by viewModel.state.map { it.isLoading }.observeAsState()

    if (isLoading === true) {
        Text(
            text = "Loading...",
            modifier = Modifier.padding(bottom = 16.dp),
        )
    }
}
