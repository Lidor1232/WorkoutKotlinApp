package com.example.workoutkotlinapp.src.screens.register.components.lastNameInput

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.R
import com.example.workoutkotlinapp.src.screens.register.RegisterIntent
import com.example.workoutkotlinapp.src.screens.register.RegisterViewModel
import kotlinx.coroutines.flow.map

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LastNameInput() {
    val registerViewModel: RegisterViewModel = viewModel()

    val lastNameInputController = LastNameInputController(registerViewModel)

    val lastName by registerViewModel.state.map { it.lastName }.collectAsState(initial = "")

    TextField(
        modifier = Modifier.padding(bottom = 16.dp),
        value = lastName,
        onValueChange = {
                text ->
            lastNameInputController.onChangeLastNameInput(text)
        },
        placeholder = {
            Text(stringResource(R.string.register_last_name_placeholder))
        },
    )
}
