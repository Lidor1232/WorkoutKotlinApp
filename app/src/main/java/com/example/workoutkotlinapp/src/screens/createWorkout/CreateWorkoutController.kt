package com.example.workoutkotlinapp.src.screens.createWorkout

import com.example.workoutkotlinapp.ActiveScreen
import com.example.workoutkotlinapp.MainIntent
import com.example.workoutkotlinapp.MainViewModel

class CreateWorkoutController(
    private val mainViewModel: MainViewModel,
    private val createWorkoutViewModel: CreateWorkoutViewModel,
) {
    fun goBack() {
        mainViewModel.processIntent(MainIntent.SetActiveScreen(ActiveScreen.UserWorkouts))
        createWorkoutViewModel.processIntent(CreateWorkoutIntent.Reset)
    }
}
