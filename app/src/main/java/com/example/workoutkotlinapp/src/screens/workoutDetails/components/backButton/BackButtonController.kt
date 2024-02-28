package com.example.workoutkotlinapp.src.screens.workoutDetails.components.backButton

import com.example.workoutkotlinapp.ActiveScreen
import com.example.workoutkotlinapp.MainIntent
import com.example.workoutkotlinapp.MainViewModel

class BackButtonController(private val mainViewModel: MainViewModel) {
    fun onClick() {
        mainViewModel.processIntent(MainIntent.SetActiveScreen(ActiveScreen.UserWorkouts))
    }
}
