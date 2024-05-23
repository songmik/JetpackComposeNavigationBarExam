package com.example.jetpackcomposenavigationbarexam.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController) {
    BottomMenuScreen(navController = navController)
}