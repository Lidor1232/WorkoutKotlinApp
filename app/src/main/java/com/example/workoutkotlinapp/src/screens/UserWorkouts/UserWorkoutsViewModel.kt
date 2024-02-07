package com.example.workoutkotlinapp.src.screens.UserWorkouts

import androidx.compose.runtime.getValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.workoutkotlinapp.src.Network.ApiClient
import com.example.workoutkotlinapp.src.Network.ApiService.routes.user.GetUserWorkoutsResponse

class UserWorkoutsViewModel : ViewModel() {
    private val _state = MutableLiveData(UserWorkoutsState())
    val state: LiveData<UserWorkoutsState> get() = _state

    fun processIntent(intent: UserWorkoutIntent) {
        when (intent) {
            is UserWorkoutIntent.SetIsLoading -> {
                _state.value = _state.value?.copy(isLoading = intent.isLoading)
            }

            is UserWorkoutIntent.SetError -> {
                _state.value = _state.value?.copy(error = intent.error)
            }

            is UserWorkoutIntent.SetWorkouts -> {
                _state.value = _state.value?.copy(workouts = intent.workouts)
            }
        }
    }

    suspend fun getUserWorkouts(): GetUserWorkoutsResponse? {
        try {
            processIntent(UserWorkoutIntent.SetIsLoading(true))
            processIntent(UserWorkoutIntent.SetError(null))
            val response = ApiClient.apiService.getUserWorkouts()
            processIntent(UserWorkoutIntent.SetIsLoading(false))
            return response
        } catch (e: retrofit2.HttpException) {
            processIntent(UserWorkoutIntent.SetError(e.message()))
            return null
        }
    }
}
