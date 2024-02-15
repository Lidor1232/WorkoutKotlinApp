package com.example.workoutkotlinapp.src.screens.UserWorkouts

import com.example.workoutkotlinapp.src.types.Workout

data class UserWorkoutsState(val isLoading: Boolean = false, val error: String? = null, val workouts: List<Workout> = listOf(), val selectedDate: String? = null)

sealed class UserWorkoutIntent {
    data class SetIsLoading(val isLoading: Boolean) : UserWorkoutIntent()

    data class SetError(val error: String?) : UserWorkoutIntent()

    data class SetWorkouts(val workouts: List<Workout>) : UserWorkoutIntent()

    data class SetSelectedDate(val selectedDate: String?) : UserWorkoutIntent()
}
