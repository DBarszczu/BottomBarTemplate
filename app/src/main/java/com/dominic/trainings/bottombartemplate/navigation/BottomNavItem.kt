package com.dominic.trainings.bottombartemplate.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiFoodBeverage
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.dominic.trainings.bottombartemplate.R


sealed class BottomNavItem(
    val route: String,
    @StringRes val titleResId: Int,
    val icon: ImageVector
) {
    object Home : BottomNavItem(
        route = Screen.Home.route,
        titleResId = R.string.screen_title_home,
        icon = Icons.Default.Home
    )
    object Training : BottomNavItem(
        route = Screen.Training.route,
        titleResId = R.string.screen_title_training,
        icon = Icons.Default.FitnessCenter
    )
    object Menu : BottomNavItem(
        route = Screen.Menu.route,
        titleResId = R.string.screen_title_menu,
        icon = Icons.Default.Menu
    )
    object Diet : BottomNavItem(
        route = Screen.Diet.route,
        titleResId = R.string.screen_title_diet,
        icon = Icons.Default.EmojiFoodBeverage
    )
    object Settings : BottomNavItem(
        route = Screen.Settings.route,
        titleResId = R.string.screen_title_settings,
        icon = Icons.Default.Settings
    )

}