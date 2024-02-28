package com.example.workoutkotlinapp

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
import com.example.workoutkotlinapp.src.screens.loading.Loading
import com.example.workoutkotlinapp.src.screens.login.Login
import com.example.workoutkotlinapp.src.screens.register.Register
import com.example.workoutkotlinapp.src.screens.userWorkouts.UserWorkouts
import com.example.workoutkotlinapp.src.screens.workoutDetails.WorkoutDetails
import com.example.workoutkotlinapp.ui.theme.WorkoutKotlinAppTheme
import kotlinx.coroutines.flow.map
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

        startKoin {
            androidContext(this@MainActivity)
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

                    val activeScreen by viewModel.state.map { it.activeScreen }.collectAsState(initial = ActiveScreen.Loading)

                    when (activeScreen) {
                        ActiveScreen.Login -> Login()
                        ActiveScreen.Register -> Register()
                        ActiveScreen.UserWorkouts -> UserWorkouts()
                        ActiveScreen.CreateWorkout -> CreateWorkout()
                        ActiveScreen.CreateExercise -> CreateExercise()
                        ActiveScreen.WorkoutDetails -> WorkoutDetails()
                        ActiveScreen.Loading -> Loading()
                    }
                }
            }
        }
    }
}
