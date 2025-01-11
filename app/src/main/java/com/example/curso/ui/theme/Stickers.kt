package com.example.curso.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.curso.R

@Composable
fun Clon(size: Dp = 100.dp) {
    Image(
        modifier = Modifier.size(size),
        painter = painterResource(R.drawable.clone_removebg_preview),
        contentDescription = "naguto"
    )
}

@Composable
fun Rocket(size: Dp = 100.dp) {
    Icon(
        painter = painterResource(R.drawable.rocket_ship),
        contentDescription = "",
        modifier = Modifier.size(size)
    )
}