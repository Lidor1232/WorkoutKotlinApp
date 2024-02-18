package com.example.workoutkotlinapp.src.screens.UserWorkouts.components.LogoutButton

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.SharedPreference.SharedPreferencesManager

@Composable
fun LogoutButton() {
    val context = LocalContext.current
    val sharedPreferencesManager = SharedPreferencesManager(context)

    val mainViewModel: MainViewModel = viewModel()

    val logoutButtonController =
        LogoutButtonController(
            mainViewModel,
            sharedPreferencesManager,
        )

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = {
            logoutButtonController.onClick()
        }) {
            Text(text = "Logout")
        }
    }
}
