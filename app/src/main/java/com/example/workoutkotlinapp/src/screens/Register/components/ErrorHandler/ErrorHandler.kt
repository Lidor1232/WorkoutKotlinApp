package com.example.workoutkotlinapp.src.screens.Register.components.ErrorHandler

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.Register.RegisterViewModel

@Composable()
fun ErrorHandler() {
    val viewModel: RegisterViewModel = viewModel()

    val error by viewModel.state.map { it.error }.observeAsState()

    if (error != null) {
        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = "$error",
            color = Color.Red,
        )
    }
}
