package com.example.workoutkotlinapp.src.screens.UserWorkouts.components.CreateWorkoutButton

import com.example.workoutkotlinapp.ActiveScreen
import com.example.workoutkotlinapp.MainIntent
import com.example.workoutkotlinapp.MainViewModel

class CreateWorkoutButtonController(private val mainViewModel: MainViewModel) {
    fun onClick() {
        mainViewModel.processIntent(MainIntent.SetActiveScreen(ActiveScreen.CreateWorkout))
    }
}
