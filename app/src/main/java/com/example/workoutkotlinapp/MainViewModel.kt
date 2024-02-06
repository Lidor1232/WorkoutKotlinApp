package com.example.workoutkotlinapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _state = MutableLiveData(MainState())
    val state: LiveData<MainState> get() = _state

    fun processIntent(intent: MainIntent) {
        when (intent) {
            is MainIntent.SetUser -> {
                _state.value = _state.value?.copy(user = intent.user)
            }

            is MainIntent.SetActiveScreen -> {
                _state.value = _state.value?.copy(activeScreen = intent.activeScreen)
            }

            is MainIntent.SetToken -> {
                _state.value = _state.value?.copy(token = intent.token)
            }
        }
    }
}
