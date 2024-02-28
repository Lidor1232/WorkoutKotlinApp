package com.example.workoutkotlinapp.src.screens.login.components.loadingHandler

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.login.LoginViewModel
import kotlinx.coroutines.flow.map

@Composable()
fun LoadingHandler() {
    val viewModel: LoginViewModel = viewModel()

    val isLoading by viewModel.state.map { it.isLoading }.collectAsState(initial = false)

    if (isLoading) {
        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = "Loading...",
        )
    }
}
