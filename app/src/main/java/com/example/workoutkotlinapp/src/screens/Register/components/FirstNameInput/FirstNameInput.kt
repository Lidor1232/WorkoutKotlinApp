package com.example.workoutkotlinapp.src.screens.Register.components.FirstNameInput

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.Register.RegisterIntent
import com.example.workoutkotlinapp.src.screens.Register.RegisterViewModel
import kotlinx.coroutines.flow.map

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstNameInput() {
    val viewModel: RegisterViewModel = viewModel()

    val firstName by viewModel.state.map { it.firstName }.collectAsState(initial = "")

    TextField(
        modifier = Modifier.padding(bottom = 16.dp),
        value = firstName,
        onValueChange = {
                text ->
            viewModel.processIntent(RegisterIntent.SetFirstName(text))
        },
        placeholder = {
            Text("First Name")
        },
    )
}
