package com.example.workoutkotlinapp.src.screens.Register.components.submitButton

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.screens.Register.RegisterViewModel
import com.example.workoutkotlinapp.src.sharedPreference.SharedPreferencesManager
import kotlinx.coroutines.flow.map

@Composable
fun SubmitButton() {
    val context = LocalContext.current
    val sharedPreferencesManager = SharedPreferencesManager(context)

    val registerViewModel: RegisterViewModel = viewModel()
    val mainViewModel: MainViewModel = viewModel()

    val submitButtonController =
        SubmitButtonController(
            registerViewModel,
            mainViewModel,
        )

    val firstName by registerViewModel.state.map { it.firstName }.collectAsState(initial = "")
    val lastName by registerViewModel.state.map { it.lastName }.collectAsState(initial = "")
    val userName by registerViewModel.state.map { it.userName }.collectAsState(initial = "")
    val password by registerViewModel.state.map { it.password }.collectAsState(initial = "")

    Button(
        modifier = Modifier.padding(bottom = 16.dp),
        onClick = {
            submitButtonController.onClick(firstName, lastName, userName, password, sharedPreferencesManager)
        },
    ) {
        Text(text = "Submit")
    }
}
