package com.example.workoutkotlinapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.koin.appModule
import com.example.workoutkotlinapp.src.screens.CreateWorkout.CreateWorkout
import com.example.workoutkotlinapp.src.screens.Login.Login
import com.example.workoutkotlinapp.src.screens.Register.Register
import com.example.workoutkotlinapp.src.screens.UserWorkouts.UserWorkouts
import com.example.workoutkotlinapp.ui.theme.WorkoutKotlinAppTheme
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.plant(
            object : Timber.DebugTree() {
                /**
                 * Override [log] to modify the tag and add a "global tag" prefix to it. You can rename the String "global_tag_" as you see fit.
                 */
                override fun log(
                    priority: Int,
                    tag: String?,
                    message: String,
                    t: Throwable?,
                ) {
                    super.log(priority, "global_tag_$tag", message, t)
                }
            },
        )

        // start Koin!
        startKoin {
            // declare used Android context
            androidContext(this@MainActivity)
            // declare modules
            modules(listOf(appModule))
        }

        Timber.d("App Created!")

        setContent {
            WorkoutKotlinAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val viewModel: MainViewModel = viewModel()
                    val state by viewModel.state.observeAsState(MainState())

                    when (state.activeScreen) {
                        ActiveScreen.Login -> {
                            Login()
                        }

                        ActiveScreen.Register -> {
                            Register()
                        }

                        ActiveScreen.UserWorkouts -> {
                            UserWorkouts()
                        }

                        ActiveScreen.CreateWorkout -> {
                            CreateWorkout()
                        }
                    }
                }
            }
        }
    }
}
