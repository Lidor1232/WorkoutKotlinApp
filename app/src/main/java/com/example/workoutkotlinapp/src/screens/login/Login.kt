package com.example.workoutkotlinapp.src.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.login.components.errorHandler.ErrorHandler
import com.example.workoutkotlinapp.src.screens.login.components.loadingHandler.LoadingHandler
import com.example.workoutkotlinapp.src.screens.login.components.passwordInput.PasswordInput
import com.example.workoutkotlinapp.src.screens.login.components.registerButton.RegisterButton
import com.example.workoutkotlinapp.src.screens.login.components.submitButton.SubmitButton
import com.example.workoutkotlinapp.src.screens.login.components.title.Title
import com.example.workoutkotlinapp.src.screens.login.components.userNameInput.UserNameInput

@Composable
fun Login() {
    val loginViewModel: LoginViewModel = viewModel()

    DisposableEffect(Unit) {
        onDispose {
            loginViewModel.processIntent(LoginIntent.Reset)
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        LoadingHandler()
        ErrorHandler()
        Title()
        UserNameInput()
        PasswordInput()
        SubmitButton()
        RegisterButton()
    }
}
