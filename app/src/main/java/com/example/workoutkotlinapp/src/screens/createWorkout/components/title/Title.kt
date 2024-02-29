package com.example.workoutkotlinapp.src.screens.createWorkout.components.title

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.workoutkotlinapp.R
import com.example.workoutkotlinapp.src.components.Titles.ScreenTitle.ScreenTitle

@Composable
fun Title() {
    ScreenTitle(
        text = stringResource(R.string.create_workout_screen_title),
    )
}
