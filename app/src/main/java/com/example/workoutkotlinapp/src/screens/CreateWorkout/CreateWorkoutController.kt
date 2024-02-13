package com.example.workoutkotlinapp.src.screens.CreateWorkout

import com.example.workoutkotlinapp.ActiveScreen
import com.example.workoutkotlinapp.MainIntent
import com.example.workoutkotlinapp.MainViewModel

class CreateWorkoutController(
    private val mainViewModel: MainViewModel,
) {
    fun goBack() {
        mainViewModel.processIntent(MainIntent.SetActiveScreen(ActiveScreen.UserWorkouts))
    }
}
