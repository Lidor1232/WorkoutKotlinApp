package com.example.workoutkotlinapp

import User

enum class ActiveScreen {
    Login,
    Register,
    UserWorkouts,
    CreateWorkout,
    CreateExercise,
    WorkoutDetails,
    Loading,
}

data class GetUserState(val isLoading: Boolean = false, val error: String? = null, val user: User? = null)

data class MainState(val getUser: GetUserState = GetUserState(), val token: String? = null, val activeScreen: ActiveScreen = ActiveScreen.Loading)

sealed class MainIntent() {
    data class GetUserSetIsLoading(val isLoading: Boolean) : MainIntent()

    data class GetUserSetError(val error: String?) : MainIntent()

    data class GetUserSetUser(val user: User?) : MainIntent()

    data class SetToken(val token: String?) : MainIntent()

    data class SetActiveScreen(val activeScreen: ActiveScreen) : MainIntent()
}
