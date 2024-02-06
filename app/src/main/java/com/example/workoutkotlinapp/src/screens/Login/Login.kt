package com.example.workoutkotlinapp.src.screens.Login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch

@Composable
fun Login() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        LoadingHandler()
        Title()
        UserNameInput()
        PasswordInput()
        SubmitButton()
        RegisterButton()
    }
}

@Composable()
fun LoadingHandler() {
    val viewModel: LoginViewModel = viewModel()
    val state by viewModel.state.observeAsState(LoginState())

    if (state.isLoading) {
        Text(
            text = "Loading...",
            modifier = Modifier.padding(bottom = 16.dp),
        )
    }
}

@Composable
fun Title() {
    Text(text = "Login Screen", modifier = Modifier.padding(bottom = 16.dp), color = Color.White)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserNameInput() {
    val viewModel: LoginViewModel = viewModel()
    val state by viewModel.state.observeAsState(LoginState())

    TextField(value = state.userName, onValueChange = {
            text ->
        viewModel.processIntent(LoginIntent.SetUserName(text))
    }, modifier = Modifier.padding(bottom = 16.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInput() {
    val viewModel: LoginViewModel = viewModel()
    val state by viewModel.state.observeAsState(LoginState())

    TextField(value = state.password, onValueChange = {
            text ->
        viewModel.processIntent(LoginIntent.SetPassword(text))
    }, modifier = Modifier.padding(bottom = 16.dp))
}

@Composable
fun SubmitButton() {
    val viewModel: LoginViewModel = viewModel()
    val state by viewModel.state.observeAsState(LoginState())

    Button(onClick = {
        viewModel.viewModelScope.launch {
            viewModel.userLogin(state.userName, state.password)
        }
    }, modifier = Modifier.padding(bottom = 16.dp)) {
        Text(text = "Submit")
    }
}

@Composable
fun RegisterButton() {
    Button(onClick = { }) {
        Text(text = "Register")
    }
}
