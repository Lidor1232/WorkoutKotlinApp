package com.example.workoutkotlinapp.src.screens.Login.components.SubmitButton

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.screens.Login.LoginViewModel

@Composable
fun SubmitButton() {
    val loginViewModel: LoginViewModel = viewModel()
    val mainViewModel: MainViewModel = viewModel()

    val submitButtonController =
        SubmitButtonController(
            mainViewModel,
            loginViewModel,
        )

    val userName by loginViewModel.state.map { it.userName }.observeAsState()
    val password by loginViewModel.state.map { it.password }.observeAsState()

    if (userName !== null && password !== null) {
        Button(
            modifier = Modifier.padding(bottom = 16.dp),
            onClick = {
                submitButtonController.onSubmit(userName, password)
            },
        ) {
            Text(text = "Submit")
        }
    }
}
