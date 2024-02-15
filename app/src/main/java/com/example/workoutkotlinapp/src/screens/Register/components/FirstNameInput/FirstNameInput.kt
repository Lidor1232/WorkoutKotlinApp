package com.example.workoutkotlinapp.src.screens.Register.components.FirstNameInput

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
fun FirstNameInput() {
    val viewModel: RegisterViewModel = viewModel()

    val firstName by viewModel.state.map { it.firstName }.observeAsState()

    if (firstName !== null) {
        TextField(value = firstName!!, onValueChange = {
                text ->
            viewModel.processIntent(RegisterIntent.SetFirstName(text))
        }, modifier = Modifier.padding(bottom = 16.dp), placeholder = {
            Text("First Name")
        })
    }
}