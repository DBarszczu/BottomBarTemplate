package com.dominic.trainings.bottombartemplate.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dominic.trainings.bottombartemplate.ui.theme.Blue2


@Composable
fun IconItemBack(
    imageVector: ImageVector,
   navController: NavController
) {
    Box(

        modifier = Modifier
            .size(50.dp)
            .clip(shape = RoundedCornerShape(30.dp))
            .background(Blue2)
            .clickable {
                navController.popBackStack()
            },
        Alignment.Center

    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            tint = Color.White
            )
    }
}