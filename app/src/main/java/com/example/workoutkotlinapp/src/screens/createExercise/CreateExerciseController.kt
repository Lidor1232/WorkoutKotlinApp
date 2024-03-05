package com.example.workoutkotlinapp.src.screens.createExercise

import com.example.workoutkotlinapp.ActiveScreen
import com.example.workoutkotlinapp.MainIntent
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.network.apiService.api.workout.ICreateExercise
import com.example.workoutkotlinapp.src.screens.createWorkout.CreateWorkoutIntent
import com.example.workoutkotlinapp.src.screens.createWorkout.CreateWorkoutViewModel
import com.example.workoutkotlinapp.src.types.Exercise

class CreateExerciseController(
    private val mainViewModel: MainViewModel,
    private val createWorkoutViewModel: CreateWorkoutViewModel,
    private val createExerciseViewModel: CreateExerciseViewModel,
) {
    fun onSubmit(
        name: String,
        sets: List<Exercise.Set>,
    ) {
        mainViewModel.processIntent(MainIntent.SetActiveScreen(ActiveScreen.CreateWorkout))
        createWorkoutViewModel.processIntent(
            CreateWorkoutIntent.AddExercise(ICreateExercise(sets = sets, name = name)),
        )
        createExerciseViewModel.processIntent(CreateExerciseIntent.Reset)
    }
}
