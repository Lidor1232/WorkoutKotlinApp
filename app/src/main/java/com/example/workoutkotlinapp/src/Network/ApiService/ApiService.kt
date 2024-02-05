package com.example.workoutkotlinapp.src.Network.ApiService

import com.example.workoutkotlinapp.src.Network.ApiService.routes.user.CreateUserApi
import com.example.workoutkotlinapp.src.Network.ApiService.routes.user.GetUserByIdApi
import com.example.workoutkotlinapp.src.Network.ApiService.routes.user.UserLoginApi

interface ApiService : GetUserByIdApi, UserLoginApi, CreateUserApi
