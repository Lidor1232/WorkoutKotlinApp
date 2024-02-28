package com.example.workoutkotlinapp.src.screens.createWorkout.components.submitButton

import com.example.workoutkotlinapp.ActiveScreen
import com.example.workoutkotlinapp.MainIntent
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.network.apiService.api.workout.ICreateExercise
import com.example.workoutkotlinapp.src.screens.createWorkout.CreateWorkoutIntent
import com.example.workoutkotlinapp.src.screens.createWorkout.CreateWorkoutViewModel
import java.util.Date

class SubmitButtonController(
    private val mainViewModel: MainViewModel,
    private val createWorkoutViewModel: CreateWorkoutViewModel,
) {
    suspend fun onSubmit(
        date: Date?,
        exercises: List<ICreateExercise>?,
        userToken: String?,
    ) {
        if (date !== null && userToken !== null && exercises !== null) {
            createWorkoutViewModel.createWorkout(date.toString(), exercises, userToken)
            mainViewModel.processIntent(MainIntent.SetActiveScreen(ActiveScreen.UserWorkouts))
            createWorkoutViewModel.processIntent(CreateWorkoutIntent.Reset)
        }
    }
}
