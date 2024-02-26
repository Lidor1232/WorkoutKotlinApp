package com.example.workoutkotlinapp.src.screens.workoutDetails

import androidx.lifecycle.ViewModel
import com.example.workoutkotlinapp.src.network.ApiClient
import com.example.workoutkotlinapp.src.network.apiService.routes.exercise.GetWorkoutExercisesResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class WorkoutDetailsViewModel() : ViewModel() {
    private val _state = MutableStateFlow(WorkoutDetailsState())
    val state: StateFlow<WorkoutDetailsState> = _state

    fun processIntent(intent: WorkoutDetailsIntent) {
        when (intent) {
            is WorkoutDetailsIntent.SetWorkout -> {
                _state.update {
                    it.copy(workout = intent.workout)
                }
            }

            is WorkoutDetailsIntent.GetExerciseSetIsLoading -> {
                val newGetExercises = _state.value?.getExercises?.copy(isLoading = intent.isLoading)
                if (newGetExercises !== null) {
                    _state.update {
                        it.copy(getExercises = newGetExercises)
                    }
                }
            }

            is WorkoutDetailsIntent.GetExerciseSetError -> {
                val newGetExercises = _state.value?.getExercises?.copy(error = intent.error)
                if (newGetExercises !== null) {
                    _state.update {
                        it.copy(getExercises = newGetExercises)
                    }
                }
            }

            is WorkoutDetailsIntent.GetExercisesSetExercises -> {
                val newGetExercises = _state.value?.getExercises?.copy(exercises = intent.exercises)
                if (newGetExercises !== null) {
                    _state.update {
                        it.copy(getExercises = newGetExercises)
                    }
                }
            }

            is WorkoutDetailsIntent.Reset -> {
                _state.update {
                    WorkoutDetailsState()
                }
            }
        }
    }

    suspend fun getExercises(
        token: String,
        workoutId: String,
    ): GetWorkoutExercisesResponse? {
        try {
            processIntent(WorkoutDetailsIntent.GetExerciseSetIsLoading(true))
            processIntent(WorkoutDetailsIntent.GetExerciseSetError(null))
            val response = ApiClient.apiService(token).getWorkoutExercises(workoutId)
            processIntent(WorkoutDetailsIntent.GetExerciseSetIsLoading(false))
            processIntent(WorkoutDetailsIntent.GetExercisesSetExercises(exercises = response.exercises))
            return response
        } catch (e: retrofit2.HttpException) {
            processIntent(WorkoutDetailsIntent.GetExerciseSetIsLoading(false))
            processIntent(WorkoutDetailsIntent.GetExerciseSetError(e.message()))
            return null
        }
    }
}
