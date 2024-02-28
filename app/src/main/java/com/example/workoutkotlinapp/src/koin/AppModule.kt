package com.example.workoutkotlinapp.src.koin

import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.screens.createExercise.CreateExerciseViewModel
import com.example.workoutkotlinapp.src.screens.createWorkout.CreateWorkoutViewModel
import com.example.workoutkotlinapp.src.screens.login.LoginViewModel
import com.example.workoutkotlinapp.src.screens.register.RegisterViewModel
import com.example.workoutkotlinapp.src.screens.userWorkouts.UserWorkoutsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule =
    module {
        viewModel {
            MainViewModel()
            LoginViewModel()
            RegisterViewModel()
            UserWorkoutsViewModel()
            CreateWorkoutViewModel()
            CreateExerciseViewModel()
        }
    }
