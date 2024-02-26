package com.example.workoutkotlinapp.src.screens.Register.components.lastNameInput

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.Register.RegisterIntent
import com.example.workoutkotlinapp.src.screens.Register.RegisterViewModel
import kotlinx.coroutines.flow.map

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LastNameInput() {
    val viewModel: RegisterViewModel = viewModel()

    val lastName by viewModel.state.map { it.lastName }.collectAsState(initial = "")

    TextField(
        modifier = Modifier.padding(bottom = 16.dp),
        value = lastName,
        onValueChange = {
                text ->
            viewModel.processIntent(RegisterIntent.SetLastName(text))
        },
        placeholder = {
            Text("Last Name")
        },
    )
}
