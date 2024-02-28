package com.example.workoutkotlinapp.src.screens.createExercise

import com.example.workoutkotlinapp.src.types.ExerciseSet

data class AddSetState(val reps: String, val weight: String)

data class CreateExerciseState(
    val name: String = "",
    val sets: List<ExerciseSet> = listOf(),
    val addSet: AddSetState = AddSetState(reps = "", weight = ""),
)

sealed class CreateExerciseIntent() {
    data class SetName(val name: String) : CreateExerciseIntent()

    data class AddSet(val set: ExerciseSet) : CreateExerciseIntent()

    data class AddSetUpdateReps(val reps: String) : CreateExerciseIntent()

    data class AddSetUpdateWeight(val weight: String) : CreateExerciseIntent()

    object Reset : CreateExerciseIntent()

    object AddSetReset : CreateExerciseIntent()
}
