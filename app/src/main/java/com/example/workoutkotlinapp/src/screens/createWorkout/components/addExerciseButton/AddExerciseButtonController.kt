package com.example.workoutkotlinapp.src.screens.createWorkout.components.addExerciseButton

import com.example.workoutkotlinapp.ActiveScreen
import com.example.workoutkotlinapp.MainIntent
import com.example.workoutkotlinapp.MainViewModel

class AddExerciseButtonController(
    private val mainViewModel: MainViewModel,
) {
    fun onClick() {
        mainViewModel.processIntent(MainIntent.SetActiveScreen(ActiveScreen.CreateExercise))
    }
}
