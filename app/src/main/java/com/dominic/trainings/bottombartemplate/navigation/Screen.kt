package com.dominic.trainings.bottombartemplate.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object Training : Screen("training_screen")
    object Menu : Screen("menu_screen")
    object Diet : Screen("diet_screen")
    object Settings : Screen("settings_screen")
    object About : Screen("about_screen")
}