package com.example.workoutkotlinapp.src.screens.CreateWorkout

import androidx.lifecycle.ViewModel
import com.example.workoutkotlinapp.src.Network.ApiClient
import com.example.workoutkotlinapp.src.Network.ApiService.routes.workout.CreateWorkoutRequest
import com.example.workoutkotlinapp.src.Network.ApiService.routes.workout.ICreateExercise
import com.example.workoutkotlinapp.src.types.Workout
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CreateWorkoutViewModel : ViewModel() {
    private val _state = MutableStateFlow(CreateWorkoutState())
    val state: StateFlow<CreateWorkoutState> = _state

    fun processIntent(intent: CreateWorkoutIntent) {
        when (intent) {
            is CreateWorkoutIntent.SetDate -> {
                _state.update {
                    it.copy(date = intent.date)
                }
            }

            is CreateWorkoutIntent.AddExercise -> {
                _state.update {
                    it.copy(exercises = _state.value.exercises + intent.exercise)
                }
            }

            is CreateWorkoutIntent.SetIsLoading -> {
                _state.update {
                    it.copy(
                        isLoading = intent.isLoading,
                    )
                }
            }

            is CreateWorkoutIntent.SetError -> {
                _state.update {
                    it.copy(
                        error = intent.error,
                    )
                }
            }

            is CreateWorkoutIntent.Reset -> {
                _state.update {
                    CreateWorkoutState()
                }
            }
        }
    }

    suspend fun createWorkout(
        date: String,
        exercises: List<ICreateExercise>,
        userToken: String,
    ): Workout? {
        try {
            processIntent(CreateWorkoutIntent.SetIsLoading(true))
            processIntent(CreateWorkoutIntent.SetError(null))
            val body = CreateWorkoutRequest(date, exercises)
            val response = ApiClient.apiService(userToken).createWorkout(body)
            processIntent(CreateWorkoutIntent.SetIsLoading(false))
            return response
        } catch (e: retrofit2.HttpException) {
            processIntent(CreateWorkoutIntent.SetIsLoading(false))
            processIntent(CreateWorkoutIntent.SetError(e.message()))
            return null
        }
    }
}
