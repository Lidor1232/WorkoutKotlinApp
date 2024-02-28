package com.example.workoutkotlinapp.src.screens.createExercise.components.nameInput

import com.example.workoutkotlinapp.src.screens.createExercise.CreateExerciseIntent
import com.example.workoutkotlinapp.src.screens.createExercise.CreateExerciseViewModel

class NameInputController(
    private val createExerciseViewModel: CreateExerciseViewModel,
) {
    fun onChangeNameInput(text: String) {
        createExerciseViewModel.processIntent(CreateExerciseIntent.SetName(text))
    }
}
