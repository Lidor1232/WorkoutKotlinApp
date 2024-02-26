package com.example.workoutkotlinapp.src.screens.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.register.components.errorHandler.ErrorHandler
import com.example.workoutkotlinapp.src.screens.register.components.firstNameInput.FirstNameInput
import com.example.workoutkotlinapp.src.screens.register.components.lastNameInput.LastNameInput
import com.example.workoutkotlinapp.src.screens.register.components.loadingHandler.LoadingHandler
import com.example.workoutkotlinapp.src.screens.register.components.loginButton.LoginButton
import com.example.workoutkotlinapp.src.screens.register.components.passwordInput.PasswordInput
import com.example.workoutkotlinapp.src.screens.register.components.submitButton.SubmitButton
import com.example.workoutkotlinapp.src.screens.register.components.title.Title
import com.example.workoutkotlinapp.src.screens.register.components.userNameInput.UserNameInput

@Composable
fun Register() {
    val registerViewModel: RegisterViewModel = viewModel()

    DisposableEffect(Unit) {
        onDispose {
            registerViewModel.processIntent(RegisterIntent.Reset)
        }
    }

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
