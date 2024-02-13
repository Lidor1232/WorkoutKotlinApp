package com.example.workoutkotlinapp.src.screens.WorkoutDetails

import com.example.workoutkotlinapp.src.types.Exercise
import com.example.workoutkotlinapp.src.types.Workout

data class GetExercisesState(val isLoading: Boolean = false, val error: String? = null, val exercises: List<Exercise> = listOf())

data class WorkoutDetailsState(val workout: Workout? = null, val getExercises: GetExercisesState = GetExercisesState())

sealed class WorkoutDetailsIntent() {
    data class SetWorkout(val workout: Workout) : WorkoutDetailsIntent()

    data class GetExerciseSetIsLoading(val isLoading: Boolean) : WorkoutDetailsIntent()

    data class GetExerciseSetError(val error: String?) : WorkoutDetailsIntent()

    data class GetExercisesSetExercises(val exercises: List<Exercise>) : WorkoutDetailsIntent()

    object Reset : WorkoutDetailsIntent()
}
