package com.example.workoutkotlinapp.src.koin

import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.screens.CreateWorkout.CreateWorkoutViewModel
import com.example.workoutkotlinapp.src.screens.Login.LoginViewModel
import com.example.workoutkotlinapp.src.screens.Register.RegisterViewModel
import com.example.workoutkotlinapp.src.screens.UserWorkouts.UserWorkoutsViewModel
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
        }
    }
