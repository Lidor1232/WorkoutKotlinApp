package com.example.workoutkotlinapp.src.koin

import com.example.workoutkotlinapp.src.screens.Login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule =
    module {
        viewModel { LoginViewModel() }
    }
