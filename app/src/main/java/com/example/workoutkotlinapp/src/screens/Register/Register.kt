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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import timber.log.Timber

@Composable
fun Register() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Title()
        FirstNameInput()
        LastNameInput()
        UserNameInput()
        PasswordInput()
        SubmitButton()
        LoginButton()
    }
}

@Preview
@Composable
fun RegisterPreview() {
    Register()
}

@Composable
fun Title() {
    Text(text = "Register Screen", color = Color.White, modifier = Modifier.padding(bottom = 16.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstNameInput() {
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
fun LastNameInput() {
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
fun UserNameInput() {
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

@Composable
fun SubmitButton() {
    val viewModel: RegisterViewModel = viewModel()
    val state by viewModel.state.observeAsState(RegisterState())

    Button(onClick = {
        Timber.d("FirstName: ${state.firstName}, LastName: ${state.lastName}, UserName ${state.userName}, Password ${state.password}")
    }, modifier = Modifier.padding(bottom = 16.dp)) {
        Text(text = "Submit")
    }
}

@Composable
fun LoginButton() {
    Button(onClick = { }) {
        Text(text = "Login")
    }
}
