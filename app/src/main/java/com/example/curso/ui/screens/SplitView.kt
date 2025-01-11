package com.example.curso.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun SplitView() {
    val configuration = LocalConfiguration.current
    val isLandscape =
        configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    if (isLandscape) {
        // Vista dividida horizontal para orientación horizontal
        Row(Modifier.fillMaxSize()) {
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.LightGray)
            ) {
                Text("Panel Izquierdo", Modifier.align(Alignment.Center))
            }
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.DarkGray)
            ) {
                Text("Panel Derecho", Modifier.align(Alignment.Center))
            }
        }
    } else {
        // Vista dividida vertical para orientación vertical
        Column(Modifier.fillMaxSize()) {
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(Color.LightGray)
            ) {
                Text("Panel Superior", Modifier.align(Alignment.Center))
            }
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(Color.DarkGray)
            ) {
                Text("Panel Inferior", Modifier.align(Alignment.Center))
            }
        }
    }
}