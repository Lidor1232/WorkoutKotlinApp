package com.example.workoutkotlinapp.src.screens.createExercise

import com.example.workoutkotlinapp.src.types.Exercise

data class AddSetState(val reps: String, val weight: String)

data class CreateExerciseState(
    val name: String = "",
    val sets: List<Exercise.Set> = listOf(),
    val addSet: AddSetState = AddSetState(reps = "", weight = ""),
)

sealed class CreateExerciseIntent() {
    data class SetName(val name: String) : CreateExerciseIntent()

    data class AddSet(val set: Exercise.Set) : CreateExerciseIntent()

    data class AddSetUpdateReps(val reps: String) : CreateExerciseIntent()

    data class AddSetUpdateWeight(val weight: String) : CreateExerciseIntent()

    object Reset : CreateExerciseIntent()

    object AddSetReset : CreateExerciseIntent()
}
