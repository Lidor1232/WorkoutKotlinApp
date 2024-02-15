package com.example.workoutkotlinapp.src.screens.Register.components.LoadingHandler

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.Register.RegisterViewModel

@Composable()
fun LoadingHandler() {
    val viewModel: RegisterViewModel = viewModel()

    val isLoading by viewModel.state.map { it.isLoading }.observeAsState()

    if (isLoading === true) {
        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = "Loading...",
        )
    }
}
