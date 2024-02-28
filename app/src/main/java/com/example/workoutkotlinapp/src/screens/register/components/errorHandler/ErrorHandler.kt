package com.example.workoutkotlinapp.src.screens.register.components.errorHandler

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.register.RegisterViewModel
import kotlinx.coroutines.flow.map

@Composable()
fun ErrorHandler() {
    val viewModel: RegisterViewModel = viewModel()

    val error by viewModel.state.map { it.error }.collectAsState(initial = null)

    if (error != null) {
        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = "$error",
            color = Color.Red,
        )
    }
}