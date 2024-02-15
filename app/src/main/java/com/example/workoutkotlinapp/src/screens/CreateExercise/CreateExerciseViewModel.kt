package com.example.workoutkotlinapp.src.screens.CreateExercise

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CreateExerciseViewModel() : ViewModel() {
    private val _state = MutableLiveData(CreateExerciseState())
    val state: LiveData<CreateExerciseState> get() = _state

    fun processIntent(intent: CreateExerciseIntent) {
        when (intent) {
            is CreateExerciseIntent.SetName -> {
                _state.value = _state.value?.copy(name = intent.name)
            }

            is CreateExerciseIntent.AddSet -> {
                if (_state.value?.sets !== null) {
                    _state.value = _state.value?.copy(sets = _state.value?.sets!! + intent.set)
                }
            }

            is CreateExerciseIntent.AddSetUpdateReps -> {
                val newAddSet = _state.value?.addSet?.copy(reps = intent.reps)
                if (newAddSet !== null) {
                    _state.value = _state.value?.copy(addSet = newAddSet)
                }
            }

            is CreateExerciseIntent.AddSetUpdateWeight -> {
                val newAddSet = _state.value?.addSet?.copy(weight = intent.weight)
                if (newAddSet !== null) {
                    _state.value = _state.value?.copy(addSet = newAddSet)
                }
            }

            is CreateExerciseIntent.Reset -> {
                _state.value = CreateExerciseState()
            }

            is CreateExerciseIntent.AddSetReset -> {
                _state.value = _state.value?.copy(addSet = AddSetState(reps = "", weight = ""))
            }
        }
    }
}
