package com.example.workoutkotlinapp.src.screens.Register.components.LastNameInput

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.Register.RegisterIntent
import com.example.workoutkotlinapp.src.screens.Register.RegisterViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LastNameInput() {
    val viewModel: RegisterViewModel = viewModel()

    val lastName by viewModel.state.map { it.lastName }.observeAsState()

    if (lastName !== null) {
        TextField(
            value = lastName!!,
            onValueChange = {
                    text ->
                viewModel.processIntent(RegisterIntent.SetLastName(text))
            },
            modifier = Modifier.padding(bottom = 16.dp),
            placeholder = {
                Text("Last Name")
            },
        )
    }
}
