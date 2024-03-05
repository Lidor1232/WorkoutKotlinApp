package com.example.workoutkotlinapp

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.koin.appModule
import com.example.workoutkotlinapp.src.screens.createExercise.CreateExercise
import com.example.workoutkotlinapp.src.screens.createWorkout.CreateWorkout
import com.example.workoutkotlinapp.src.screens.initAppLoading.InitAppLoading
import com.example.workoutkotlinapp.src.screens.login.Login
import com.example.workoutkotlinapp.src.screens.register.Register
import com.example.workoutkotlinapp.src.screens.userWorkouts.UserWorkouts
import com.example.workoutkotlinapp.src.screens.workoutDetails.WorkoutDetails
import com.example.workoutkotlinapp.ui.theme.WorkoutKotlinAppTheme
import kotlinx.coroutines.flow.map
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidContext(this@App)
            modules(listOf(appModule))
        }

        Timber.d("Koin started with appModule.")
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WorkoutKotlinAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val viewModel: MainViewModel = viewModel()

                    val activeScreen by viewModel.state.map { it.activeScreen }.collectAsState(initial = ActiveScreen.InitAppLoading)

                    when (activeScreen) {
                        ActiveScreen.Login -> Login()
                        ActiveScreen.Register -> Register()
                        ActiveScreen.UserWorkouts -> UserWorkouts()
                        ActiveScreen.CreateWorkout -> CreateWorkout()
                        ActiveScreen.CreateExercise -> CreateExercise()
                        ActiveScreen.WorkoutDetails -> WorkoutDetails()
                        ActiveScreen.InitAppLoading -> InitAppLoading()
                    }
                }
            }
        }
    }
}
