package com.example.workoutkotlinapp.src.screens.login.components.title

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.workoutkotlinapp.src.components.Titles.ScreenTitle.ScreenTitle
import com.example.workoutkotlinapp.R

@Composable
fun Title() {
    ScreenTitle(
        text = stringResource(R.string.login_screen_title),
    )
}
