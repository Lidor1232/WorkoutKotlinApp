package com.example.workoutkotlinapp.src.screens.Login.components.RegisterButton

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.ActiveScreen
import com.example.workoutkotlinapp.MainIntent
import com.example.workoutkotlinapp.MainViewModel

@Composable
fun RegisterButton() {
    val viewModel: MainViewModel = viewModel()

    Button(onClick = {
        viewModel.processIntent(MainIntent.SetActiveScreen(ActiveScreen.Register))
    }) {
        Text(text = "Register")
    }
}
