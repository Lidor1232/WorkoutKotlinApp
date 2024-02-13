package com.example.workoutkotlinapp.src.screens.WorkoutDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.workoutkotlinapp.src.Network.ApiClient
import com.example.workoutkotlinapp.src.Network.ApiService.routes.exercise.GetWorkoutExercisesResponse

class WorkoutDetailsViewModel() : ViewModel() {
    private val _state = MutableLiveData(WorkoutDetailsState())
    val state: LiveData<WorkoutDetailsState> = _state

    fun processIntent(intent: WorkoutDetailsIntent) {
        when (intent) {
            is WorkoutDetailsIntent.SetWorkout -> {
                _state.value = _state.value?.copy(workout = intent.workout)
            }

            is WorkoutDetailsIntent.GetExerciseSetIsLoading -> {
                val newGetExercises = _state.value?.getExercises?.copy(isLoading = intent.isLoading)
                if (newGetExercises !== null) {
                    _state.value = _state.value?.copy(getExercises = newGetExercises)
                }
            }

            is WorkoutDetailsIntent.GetExerciseSetError -> {
                val newGetExercises = _state.value?.getExercises?.copy(error = intent.error)
                if (newGetExercises !== null) {
                    _state.value = _state.value?.copy(getExercises = newGetExercises)
                }
            }

            is WorkoutDetailsIntent.GetExercisesSetExercises -> {
                val newGetExercises = _state.value?.getExercises?.copy(exercises = intent.exercises)
                if (newGetExercises !== null) {
                    _state.value = _state.value?.copy(getExercises = newGetExercises)
                }
            }

            is WorkoutDetailsIntent.Reset -> {
                _state.value = WorkoutDetailsState()
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
            return null
        }
    }
}
