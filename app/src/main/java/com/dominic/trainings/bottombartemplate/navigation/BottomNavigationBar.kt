package com.dominic.trainings.bottombartemplate.navigation

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.NavigationRailItem
import androidx.compose.material.Text
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dominic.trainings.bottombartemplate.ui.theme.Blue1
import com.dominic.trainings.bottombartemplate.ui.theme.Blue2

@Composable
fun BottomNavigationBar(
    navController: NavController
) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Training,
        BottomNavItem.Menu,
        BottomNavItem.Diet,
        BottomNavItem.Settings
    )
    BottomAppBar(
        modifier = Modifier.clip(
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
        ),

        containerColor = Blue2,
        tonalElevation = 50.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            val isSelected = currentRoute == item.route
            val rotationAngle by animateFloatAsState(
                targetValue = if (isSelected) 0f else 10f,
                animationSpec = keyframes {
                    durationMillis = 800
                    0f at 0 with LinearOutSlowInEasing // Początkowa wartość
                    15f at 100 with FastOutSlowInEasing // Drganie w prawo
                    -15f at 300 with FastOutSlowInEasing // Drganie w lewo
                    10f at 400 with FastOutSlowInEasing // Drganie w prawo
                    -10f at 500 with FastOutSlowInEasing // Drganie w lewo
                    0f at 600 with LinearOutSlowInEasing // Powrót do pierwotnej wartości
                }
            )
            NavigationBarItem(

                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Blue1


                ),

                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = stringResource(id = item.titleResId),
                        tint = if (isSelected) Color.White else Color.White,
                        modifier = Modifier
                            .let { if (isSelected) it.rotate(rotationAngle) else it }
                            .size(23.dp)
                    )
                },

                label = {
                    Text(
                        text = stringResource(id = item.titleResId),
                        color = Color.White
                    )
                },
                selected = isSelected,
                onClick = {
                    if (isSelected) {
                        // Wykonać odpowiednie działanie po kliknięciu na zaznaczony element
                    } else {
                        navController.navigate(item.route) {
                            // Pop up to the start destination of the graph to
                            // avoid building up a large stack of destinations
                            // on the back stack as users select items
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            // Avoid multiple copies of the same destination when re-selecting the same item
                            // launchSingleTop = true
                            // Restore state when re-selecting a previously selected item
                            restoreState = true
                        }
                    }
                },
                alwaysShowLabel = true, // Ukrycie etykiety przycisku, jeśli nie jest zaznaczony
//                selectedContentColor = Color.Magenta, // Kolor ikony dla zaznaczonego przycisku
//                unselectedContentColor = Color.Gray // Kolor ikony dla niezaznaczonego przycisku
            )

            /**Use can use diferent style of BottomBar**/

            /*            BottomNavigationItem(


                            icon = {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = stringResource(id = item.titleResId),
                                    tint = if (isSelected) Color.Magenta else Color.White,
                                    modifier = Modifier
                                        .let { if (isSelected) it.rotate(rotationAngle) else it }
                                        .size(23.dp)
                                )
                            },

                            label = {
                                Text(
                                    text = stringResource(id = item.titleResId),

                                )
                            },
                            selected = isSelected,
                            onClick = {
                                if (isSelected) {
                                    // Wykonać odpowiednie działanie po kliknięciu na zaznaczony element
                                } else {
                                    navController.navigate(item.route) {
                                        // Pop up to the start destination of the graph to
                                        // avoid building up a large stack of destinations
                                        // on the back stack as users select items
                                        navController.graph.startDestinationRoute?.let { route ->
                                            popUpTo(route) {
                                                saveState = true
                                            }
                                        }
                                        // Avoid multiple copies of the same destination when re-selecting the same item
                                        // launchSingleTop = true
                                        // Restore state when re-selecting a previously selected item
                                        restoreState = true
                                    }
                                }
                            },
                            alwaysShowLabel = true, // Ukrycie etykiety przycisku, jeśli nie jest zaznaczony
                            selectedContentColor = Color.Magenta, // Kolor ikony dla zaznaczonego przycisku
                            unselectedContentColor = Color.White // Kolor ikony dla niezaznaczonego przycisku
                        )*/
        }

    }
}