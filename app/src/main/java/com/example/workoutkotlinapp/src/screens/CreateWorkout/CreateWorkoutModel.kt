package com.example.workoutkotlinapp.src.screens.CreateWorkout

import com.example.workoutkotlinapp.src.Network.ApiService.routes.workout.ICreateExercise
import java.util.Date

data class CreateWorkoutState(val date: Date? = null, val exercises: List<ICreateExercise> = listOf(), val isLoading: Boolean = false, val error: String? = null)

sealed class CreateWorkoutIntent() {
    data class SetDate(val date: Date) : CreateWorkoutIntent()

    data class AddExercise(val exercise: ICreateExercise) : CreateWorkoutIntent()

    data class SetIsLoading(val isLoading: Boolean) : CreateWorkoutIntent()

    data class SetError(val error: String?) : CreateWorkoutIntent()
}
