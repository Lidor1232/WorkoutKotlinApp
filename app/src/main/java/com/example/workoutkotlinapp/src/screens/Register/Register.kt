package com.example.workoutkotlinapp.src.screens.Register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.workoutkotlinapp.src.screens.Register.components.FirstNameInput.FirstNameInput
import com.example.workoutkotlinapp.src.screens.Register.components.LastNameInput.LastNameInput
import com.example.workoutkotlinapp.src.screens.Register.components.LoadingHandler.LoadingHandler
import com.example.workoutkotlinapp.src.screens.Register.components.LoginButton.LoginButton
import com.example.workoutkotlinapp.src.screens.Register.components.PasswordInput.PasswordInput
import com.example.workoutkotlinapp.src.screens.Register.components.SubmitButton.SubmitButton
import com.example.workoutkotlinapp.src.screens.Register.components.Title.Title
import com.example.workoutkotlinapp.src.screens.Register.components.UserNameInput.UserNameInput
import com.example.workoutkotlinapp.src.screens.Register.components.ErrorHandler.ErrorHandler

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
