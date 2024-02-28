package com.example.workoutkotlinapp.src.screens.createExercise

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CreateExerciseViewModel() : ViewModel() {
    private val _state = MutableStateFlow(CreateExerciseState())
    val state: StateFlow<CreateExerciseState> = _state

    fun processIntent(intent: CreateExerciseIntent) {
        when (intent) {
            is CreateExerciseIntent.SetName -> {
                _state.update {
                    it.copy(name = intent.name)
                }
            }

            is CreateExerciseIntent.AddSet -> {
                _state.update {
                    it.copy(sets = _state.value.sets + intent.set)
                }
            }

            is CreateExerciseIntent.AddSetUpdateReps -> {
                val newAddSet = _state.value?.addSet?.copy(reps = intent.reps)
                if (newAddSet !== null) {
                    _state.update {
                        it.copy(
                            addSet = newAddSet,
                        )
                    }
                }
            }

            is CreateExerciseIntent.AddSetUpdateWeight -> {
                val newAddSet = _state.value?.addSet?.copy(weight = intent.weight)
                if (newAddSet !== null) {
                    _state.update {
                        it.copy(
                            addSet = newAddSet,
                        )
                    }
                }
            }

            is CreateExerciseIntent.Reset -> {
                _state.update {
                    CreateExerciseState()
                }
            }

            is CreateExerciseIntent.AddSetReset -> {
                _state.update {
                    it.copy(addSet = AddSetState(reps = "", weight = ""))
                }
            }
        }
    }
}
