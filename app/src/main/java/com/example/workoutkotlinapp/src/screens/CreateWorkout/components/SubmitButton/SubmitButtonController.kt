package com.example.workoutkotlinapp.src.screens.CreateWorkout.components.SubmitButton

import com.example.workoutkotlinapp.ActiveScreen
import com.example.workoutkotlinapp.MainIntent
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.Network.ApiService.routes.workout.ICreateExercise
import com.example.workoutkotlinapp.src.screens.CreateWorkout.CreateWorkoutIntent
import com.example.workoutkotlinapp.src.screens.CreateWorkout.CreateWorkoutViewModel
import java.util.Date

class SubmitButtonController(
    private val mainViewModel: MainViewModel,
    private val createWorkoutViewModel: CreateWorkoutViewModel,
) {
    suspend fun onSubmit(
        date: Date?,
        exercises: List<ICreateExercise>,
        userToken: String?,
    ) {
        if (date !== null && userToken !== null) {
            createWorkoutViewModel.createWorkout(date.toString(), exercises, userToken)
            createWorkoutViewModel.processIntent(CreateWorkoutIntent.Reset)
            mainViewModel.processIntent(MainIntent.SetActiveScreen(ActiveScreen.UserWorkouts))
        }
    }
}
