package com.example.workoutkotlinapp.src.screens.Register.components.PasswordInput

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.Register.RegisterIntent
import com.example.workoutkotlinapp.src.screens.Register.RegisterState
import com.example.workoutkotlinapp.src.screens.Register.RegisterViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInput() {
    val viewModel: RegisterViewModel = viewModel()
    val state by viewModel.state.observeAsState(RegisterState())

    TextField(value = state.password, onValueChange = {
            text ->
        viewModel.processIntent(RegisterIntent.SetPassword(text))
    }, modifier = Modifier.padding(bottom = 16.dp), placeholder = {
        Text("Password")
    })
}
