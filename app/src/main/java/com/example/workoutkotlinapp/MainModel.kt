package com.example.workoutkotlinapp

import User

enum class ActiveScreen {
    Login,
    Register,
}

data class MainState(val user: User? = null, val token: String? = null, val activeScreen: ActiveScreen = ActiveScreen.Login)

sealed class MainIntent() {
    data class SetUser(val user: User?) : MainIntent()

    data class SetToken(val token: String?) : MainIntent()

    data class SetActiveScreen(val activeScreen: ActiveScreen) : MainIntent()
}
