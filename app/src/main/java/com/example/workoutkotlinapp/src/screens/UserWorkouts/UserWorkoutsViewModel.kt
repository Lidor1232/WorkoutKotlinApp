package com.example.workoutkotlinapp.src.screens.UserWorkouts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.workoutkotlinapp.src.Network.ApiClient
import com.example.workoutkotlinapp.src.Network.ApiService.routes.user.GetUserWorkoutsResponse
import timber.log.Timber
import java.time.LocalDate

class UserWorkoutsViewModel : ViewModel() {
    private val _state = MutableLiveData(UserWorkoutsState())
    val state: LiveData<UserWorkoutsState> get() = _state

    fun processIntent(intent: UserWorkoutsIntent) {
        when (intent) {
            is UserWorkoutsIntent.SetIsLoading -> {
                _state.value = _state.value?.copy(isLoading = intent.isLoading)
            }

            is UserWorkoutsIntent.SetError -> {
                _state.value = _state.value?.copy(error = intent.error)
            }

            is UserWorkoutsIntent.SetWorkouts -> {
                _state.value = _state.value?.copy(workouts = intent.workouts)
            }

            is UserWorkoutsIntent.SetSelectedDate -> {
                _state.value = _state.value?.copy(selectedDate = intent.selectedDate)
            }

            is UserWorkoutsIntent.Reset -> {
                _state.value = UserWorkoutsState()
            }
        }
    }

    suspend fun getUserWorkouts(token: String): GetUserWorkoutsResponse? {
        try {
            processIntent(UserWorkoutsIntent.SetIsLoading(true))
            processIntent(UserWorkoutsIntent.SetError(null))
            val response = ApiClient.apiService(token).getUserWorkouts()
            Timber.d("WORKOUTS: response: $response")
            processIntent(UserWorkoutsIntent.SetIsLoading(false))
            processIntent(UserWorkoutsIntent.SetWorkouts(response.workouts))
            return response
        } catch (e: retrofit2.HttpException) {
            processIntent(UserWorkoutsIntent.SetIsLoading(false))
            processIntent(UserWorkoutsIntent.SetError(e.message()))
            return null
        }
    }

    fun handleDateSelection(selection: List<LocalDate>) {
        if (selection.isNotEmpty()) {
            val selectedDate = selection[0]
            processIntent(
                UserWorkoutsIntent.SetSelectedDate(selectedDate.toString()),
            )
        }
    }
}
