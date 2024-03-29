package com.example.workoutkotlinapp.src.screens.initAppLoading

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.sharedPreference.SharedPreferencesManager

@Composable
fun InitAppLoading() {
    val context = LocalContext.current
    val sharedPreferencesManager = SharedPreferencesManager(context)

    val mainViewModel: MainViewModel = viewModel()

    LaunchedEffect(Unit) {
        mainViewModel.initUserSession(sharedPreferencesManager)
    }

    Column(
        modifier =
            Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CircularProgressIndicator()
    }
}
