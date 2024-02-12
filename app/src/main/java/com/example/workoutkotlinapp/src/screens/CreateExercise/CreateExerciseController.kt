package com.example.workoutkotlinapp.src.screens.CreateExercise

import com.example.workoutkotlinapp.ActiveScreen
import com.example.workoutkotlinapp.MainIntent
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.Network.ApiService.routes.workout.ICreateExercise
import com.example.workoutkotlinapp.src.screens.CreateWorkout.CreateWorkoutIntent
import com.example.workoutkotlinapp.src.screens.CreateWorkout.CreateWorkoutViewModel
import com.example.workoutkotlinapp.src.types.ExerciseSet

class CreateExerciseController(
    private val mainViewModel: MainViewModel,
    private val createWorkoutViewModel: CreateWorkoutViewModel,
    private val createExerciseViewModel: CreateExerciseViewModel,
) {
    fun onSubmit(
        name: String?,
        sets: List<ExerciseSet>?,
    ) {
        mainViewModel.processIntent(MainIntent.SetActiveScreen(ActiveScreen.CreateWorkout))
        if (name !== null && sets !== null) {
            createWorkoutViewModel.processIntent(
                CreateWorkoutIntent.AddExercise(ICreateExercise(sets = sets, name = name)),
            )
        }
    }
}
