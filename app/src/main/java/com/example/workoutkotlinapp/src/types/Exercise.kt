package com.example.workoutkotlinapp.src.types

data class Exercise(val id: String, val name: String, val workout: String, val sets: List<Set>) {
    data class Set(val weight: Int, val reps: Int)
}
