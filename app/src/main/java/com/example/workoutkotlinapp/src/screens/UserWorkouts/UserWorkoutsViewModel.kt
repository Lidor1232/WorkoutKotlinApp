package com.example.workoutkotlinapp.src.screens.UserWorkouts

import androidx.lifecycle.ViewModel
import com.example.workoutkotlinapp.src.Network.ApiClient
import com.example.workoutkotlinapp.src.Network.ApiService.routes.user.GetUserWorkoutsResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDate

class UserWorkoutsViewModel : ViewModel() {
    private val _state = MutableStateFlow(UserWorkoutsState())
    val state: StateFlow<UserWorkoutsState> = _state

    fun processIntent(intent: UserWorkoutsIntent) {
        when (intent) {
            is UserWorkoutsIntent.SetIsLoading -> {
                _state.update {
                    it.copy(isLoading = intent.isLoading)
                }
            }

            is UserWorkoutsIntent.SetError -> {
                _state.update {
                    it.copy(
                        error = intent.error,
                    )
                }
            }

            is UserWorkoutsIntent.SetWorkouts -> {
                _state.update {
                    it.copy(workouts = intent.workouts)
                }
            }

            is UserWorkoutsIntent.SetSelectedDate -> {
                _state.update {
                    it.copy(selectedDate = intent.selectedDate)
                }
            }

            is UserWorkoutsIntent.Reset -> {
                _state.update {
                    UserWorkoutsState()
                }
            }
        }
    }

    suspend fun getUserWorkouts(
        token: String,
        userId: String,
    ): GetUserWorkoutsResponse? {
        try {
            processIntent(UserWorkoutsIntent.SetIsLoading(true))
            processIntent(UserWorkoutsIntent.SetError(null))
            val response = ApiClient.apiService(token).getUserWorkouts(userId)
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
