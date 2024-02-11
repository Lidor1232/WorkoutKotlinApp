package com.example.workoutkotlinapp.src.screens.Register

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
import com.example.workoutkotlinapp.ActiveScreen
import com.example.workoutkotlinapp.MainIntent
import com.example.workoutkotlinapp.MainViewModel
import kotlinx.coroutines.launch
import timber.log.Timber

@Composable
fun Register() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        ErrorHandler()
        LoadingHandler()
        Title()
        FirstNameInput()
        LastNameInput()
        UserNameInput()
        PasswordInput()
        SubmitButton()
        LoginButton()
    }
}

@Composable()
private fun ErrorHandler() {
    val viewModel: RegisterViewModel = viewModel()
    val state by viewModel.state.observeAsState(RegisterState())

    if (state.error != null) {
        Text(
            text = "${state.error}",
            modifier = Modifier.padding(bottom = 16.dp),
            color = Color.Red,
        )
    }
}

@Composable()
private fun LoadingHandler() {
    val viewModel: RegisterViewModel = viewModel()
    val state by viewModel.state.observeAsState(RegisterState())

    if (state.isLoading) {
        Text(
            text = "Loading...",
            modifier = Modifier.padding(bottom = 16.dp),
        )
    }
}

@Composable
private fun Title() {
    Text(
        text = "Register Screen",
        modifier = Modifier.padding(bottom = 16.dp),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FirstNameInput() {
    val viewModel: RegisterViewModel = viewModel()
    val state by viewModel.state.observeAsState(RegisterState())

    TextField(value = state.firstName, onValueChange = {
            text ->
        viewModel.processIntent(RegisterIntent.SetFirstName(text))
    }, modifier = Modifier.padding(bottom = 16.dp), placeholder = {
        Text("First Name")
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LastNameInput() {
    val viewModel: RegisterViewModel = viewModel()
    val state by viewModel.state.observeAsState(RegisterState())

    TextField(
        value = state.lastName,
        onValueChange = {
                text ->
            viewModel.processIntent(RegisterIntent.SetLastName(text))
        },
        modifier = Modifier.padding(bottom = 16.dp),
        placeholder = {
            Text("Last Name")
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun UserNameInput() {
    val viewModel: RegisterViewModel = viewModel()
    val state by viewModel.state.observeAsState(RegisterState())

    TextField(value = state.userName, onValueChange = {
            text ->
        viewModel.processIntent(RegisterIntent.SetUserName(text))
    }, modifier = Modifier.padding(bottom = 16.dp), placeholder = {
        Text("User Name")
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PasswordInput() {
    val viewModel: RegisterViewModel = viewModel()
    val state by viewModel.state.observeAsState(RegisterState())

    TextField(value = state.password, onValueChange = {
            text ->
        viewModel.processIntent(RegisterIntent.SetPassword(text))
    }, modifier = Modifier.padding(bottom = 16.dp), placeholder = {
        Text("Password")
    })
}

@Composable
private fun SubmitButton() {
    val registerViewModel: RegisterViewModel = viewModel()
    val mainViewModel: MainViewModel = viewModel()
    val state by registerViewModel.state.observeAsState(RegisterState())

    Button(onClick = {
        registerViewModel.viewModelScope.launch {
            val response =
                registerViewModel.userRegister(
                    state.firstName,
                    state.lastName,
                    state.userName,
                    state.password,
                )
            if (response != null) {
                mainViewModel.processIntent(MainIntent.SetToken(response.token))
                mainViewModel.processIntent(MainIntent.SetUser(response.user))
                mainViewModel.processIntent(MainIntent.SetActiveScreen(ActiveScreen.UserWorkouts))
                Timber.d("Register User: $response")
            }
        }
    }, modifier = Modifier.padding(bottom = 16.dp)) {
        Text(text = "Submit")
    }
}

@Composable
private fun LoginButton() {
    val viewModel: MainViewModel = viewModel()

    Button(onClick = {
        viewModel.processIntent(MainIntent.SetActiveScreen(ActiveScreen.Login))
    }) {
        Text(text = "Login")
    }
}
