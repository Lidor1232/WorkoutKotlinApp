package com.example.workoutkotlinapp.src.screens.login.components.userNameInput

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
import com.example.workoutkotlinapp.src.screens.login.LoginViewModel
import kotlinx.coroutines.flow.map

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserNameInput() {
    val loginViewModel: LoginViewModel = viewModel()

    val userNameInputController =
        UserNameInputController(
            loginViewModel,
        )

    val userName by loginViewModel.state.map { it.userName }.collectAsState(initial = "")

    TextField(
        modifier = Modifier.padding(bottom = 16.dp),
        value = userName,
        onValueChange = {
                text ->
            userNameInputController.onChangeUserNameInput(text)
        },
        placeholder = {
            Text(text = stringResource(R.string.login_username_placeholder))
        },
    )
}
