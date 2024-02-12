package com.example.workoutkotlinapp.src.types

data class Exercise(val _id: String, val name: String, val workout: String, val sets: List<ExerciseSet>)
