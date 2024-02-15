package com.example.workoutkotlinapp.src.Network.ApiService

import com.example.workoutkotlinapp.src.Network.ApiService.routes.exercise.GetWorkoutExercises
import com.example.workoutkotlinapp.src.Network.ApiService.routes.user.CreateUserApi
import com.example.workoutkotlinapp.src.Network.ApiService.routes.user.GetUserByIdApi
import com.example.workoutkotlinapp.src.Network.ApiService.routes.user.GetUserWorkoutsApi
import com.example.workoutkotlinapp.src.Network.ApiService.routes.user.UserLoginApi
import com.example.workoutkotlinapp.src.Network.ApiService.routes.workout.CreateWorkoutApi

interface ApiService : GetUserByIdApi, UserLoginApi, CreateUserApi, GetWorkoutExercises, CreateWorkoutApi, GetUserWorkoutsApi
