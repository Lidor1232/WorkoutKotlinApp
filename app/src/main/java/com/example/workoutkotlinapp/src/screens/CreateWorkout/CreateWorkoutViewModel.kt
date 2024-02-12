package com.example.workoutkotlinapp.src.screens.CreateWorkout

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.workoutkotlinapp.src.Network.ApiClient
import com.example.workoutkotlinapp.src.Network.ApiService.routes.workout.CreateWorkoutRequest
import com.example.workoutkotlinapp.src.Network.ApiService.routes.workout.ICreateExercise
import com.example.workoutkotlinapp.src.types.Workout

class CreateWorkoutViewModel : ViewModel() {
    private val _state = MutableLiveData(CreateWorkoutState())
    val state: LiveData<CreateWorkoutState> get() = _state

    fun processIntent(intent: CreateWorkoutIntent) {
        when (intent) {
            is CreateWorkoutIntent.SetDate -> {
                _state.value = _state.value?.copy(date = intent.date)
            }

            is CreateWorkoutIntent.AddExercise -> {
                if (_state.value?.exercises !== null) {
                    _state.value = _state.value?.copy(exercises = _state.value?.exercises!! + intent.exercise)
                }
            }

            is CreateWorkoutIntent.SetIsLoading -> {
                _state.value = _state.value?.copy(isLoading = intent.isLoading)
            }

            is CreateWorkoutIntent.SetError -> {
                _state.value = _state.value?.copy(error = intent.error)
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
