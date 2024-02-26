package com.example.workoutkotlinapp.src.network.apiService

import com.example.workoutkotlinapp.src.network.apiService.routes.exercise.GetWorkoutExercises
import com.example.workoutkotlinapp.src.network.apiService.routes.user.CreateUserApi
import com.example.workoutkotlinapp.src.network.apiService.routes.user.GetUserApi
import com.example.workoutkotlinapp.src.network.apiService.routes.user.GetUserWorkoutsApi
import com.example.workoutkotlinapp.src.network.apiService.routes.user.UserLoginApi
import com.example.workoutkotlinapp.src.network.apiService.routes.workout.CreateWorkoutApi

interface ApiService : GetUserApi, UserLoginApi, CreateUserApi, GetWorkoutExercises, CreateWorkoutApi, GetUserWorkoutsApi
