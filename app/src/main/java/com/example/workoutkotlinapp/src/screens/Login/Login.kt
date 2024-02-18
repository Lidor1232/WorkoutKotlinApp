package com.example.workoutkotlinapp.src.screens.Login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.Login.components.ErrorHandler.ErrorHandler
import com.example.workoutkotlinapp.src.screens.Login.components.LoadingHandler.LoadingHandler
import com.example.workoutkotlinapp.src.screens.Login.components.PasswordInput.PasswordInput
import com.example.workoutkotlinapp.src.screens.Login.components.RegisterButton.RegisterButton
import com.example.workoutkotlinapp.src.screens.Login.components.SubmitButton.SubmitButton
import com.example.workoutkotlinapp.src.screens.Login.components.Title.Title
import com.example.workoutkotlinapp.src.screens.Login.components.UserNameInput.UserNameInput

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
