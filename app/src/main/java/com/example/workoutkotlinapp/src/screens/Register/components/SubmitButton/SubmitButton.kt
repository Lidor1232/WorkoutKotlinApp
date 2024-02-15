package com.example.workoutkotlinapp.src.screens.Register.components.SubmitButton

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
import com.example.workoutkotlinapp.src.screens.Register.RegisterViewModel

@Composable
fun SubmitButton() {
    val registerViewModel: RegisterViewModel = viewModel()
    val mainViewModel: MainViewModel = viewModel()

    val submitButtonController =
        SubmitButtonController(
            registerViewModel,
            mainViewModel,
        )

    val firstName by registerViewModel.state.map { it.firstName }.observeAsState()
    val lastName by registerViewModel.state.map { it.lastName }.observeAsState()
    val userName by registerViewModel.state.map { it.userName }.observeAsState()
    val password by registerViewModel.state.map { it.password }.observeAsState()

    if (firstName !== null && lastName !== null && userName !== null && password !== null) {
        Button(
            modifier = Modifier.padding(bottom = 16.dp),
            onClick = {
                submitButtonController.onClick(firstName!!, lastName!!, userName!!, password!!)
            },
        ) {
            Text(text = "Submit")
        }
    }
}
