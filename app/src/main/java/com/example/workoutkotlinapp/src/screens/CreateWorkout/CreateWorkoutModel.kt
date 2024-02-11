package com.example.workoutkotlinapp.src.screens.CreateWorkout

import com.example.workoutkotlinapp.src.Network.ApiService.routes.workout.CreateExercise

data class CreateWorkoutState(val date: String = "", val exercises: List<CreateExercise> = listOf(), val isLoading: Boolean = false, val error: String? = null)

sealed class CreateWorkoutIntent() {
    data class SetDate(val date: String) : CreateWorkoutIntent()

    data class AddExercise(val exercise: CreateExercise) : CreateWorkoutIntent()

    data class SetIsLoading(val isLoading: Boolean) : CreateWorkoutIntent()

    data class SetError(val error: String?) : CreateWorkoutIntent()
}
