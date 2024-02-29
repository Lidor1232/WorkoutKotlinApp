package com.example.workoutkotlinapp.src.types

data class Exercise(val id: String, val name: String, val workout: String, val sets: List<ExerciseSet>)
