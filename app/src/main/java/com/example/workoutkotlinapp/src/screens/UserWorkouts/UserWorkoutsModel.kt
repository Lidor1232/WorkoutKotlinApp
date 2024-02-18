package com.example.workoutkotlinapp.src.screens.UserWorkouts

import com.example.workoutkotlinapp.src.types.Workout

data class UserWorkoutsState(val isLoading: Boolean = false, val error: String? = null, val workouts: List<Workout> = listOf(), val selectedDate: String? = null)

sealed class UserWorkoutsIntent {
    data class SetIsLoading(val isLoading: Boolean) : UserWorkoutsIntent()

    data class SetError(val error: String?) : UserWorkoutsIntent()

    data class SetWorkouts(val workouts: List<Workout>) : UserWorkoutsIntent()

    data class SetSelectedDate(val selectedDate: String?) : UserWorkoutsIntent()

    object Reset : UserWorkoutsIntent()
}
