package com.dominic.trainings.bottombartemplate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dominic.trainings.bottombartemplate.screens.AboutScreen
import com.dominic.trainings.bottombartemplate.screens.DietScreen
import com.dominic.trainings.bottombartemplate.screens.HomeScreen
import com.dominic.trainings.bottombartemplate.screens.MenuScreen
import com.dominic.trainings.bottombartemplate.screens.SettingsScreen
import com.dominic.trainings.bottombartemplate.screens.TrainingScreen

@Composable
fun NavigationSetup(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Home.route) {
            HomeScreen()
        }
        composable(BottomNavItem.Training.route) {
            TrainingScreen()
        }
        composable(BottomNavItem.Menu.route) {
            MenuScreen()
        }
        composable(BottomNavItem.Diet.route) {
            DietScreen()
        }
        composable(BottomNavItem.Settings.route) {
            SettingsScreen(navController)
        }
        composable(Screen.About.route) {
            AboutScreen(navController)
        }
    }
}