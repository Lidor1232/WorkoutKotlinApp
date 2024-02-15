package com.example.workoutkotlinapp.src.screens.Register.components.UserNameInput

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
import com.example.workoutkotlinapp.src.screens.Register.RegisterViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserNameInput() {
    val registerViewModel: RegisterViewModel = viewModel()

    val userNameInputController = UserNameInputController(registerViewModel)

    val userName by registerViewModel.state.map { it.userName }.observeAsState()

    if (userName !== null) {
        TextField(
            modifier = Modifier.padding(bottom = 16.dp),
            value = userName!!,
            placeholder = {
                Text("User Name")
            },
            onValueChange = {
                    text ->
                userNameInputController.onUserNameInputChange(text)
            },
        )
    }
}
