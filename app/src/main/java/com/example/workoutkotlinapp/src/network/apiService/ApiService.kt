package com.example.workoutkotlinapp.src.network.apiService

import com.example.workoutkotlinapp.src.network.apiService.api.exercise.GetWorkoutExercises
import com.example.workoutkotlinapp.src.network.apiService.api.user.CreateUserApi
import com.example.workoutkotlinapp.src.network.apiService.api.user.GetUserApi
import com.example.workoutkotlinapp.src.network.apiService.api.user.GetUserWorkoutsApi
import com.example.workoutkotlinapp.src.network.apiService.api.user.UserLoginApi
import com.example.workoutkotlinapp.src.network.apiService.api.workout.CreateWorkoutApi

interface ApiService : GetUserApi, UserLoginApi, CreateUserApi, GetWorkoutExercises, CreateWorkoutApi, GetUserWorkoutsApi
