package com.example.curso.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AlineacionEnCaja() {
    var alignment by remember { mutableStateOf(Alignment.Center) }

    Box(
        modifier = Modifier
            .background(Color(0xFFfa693d))
            .padding(10.dp)
            .fillMaxSize(),
        contentAlignment = alignment
    ) {
        Box(
            modifier = Modifier
                .background(Color(0xFF00A2E8))
                .size(150.dp)
        )
        FlowRow(
            modifier = Modifier.align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Button(onClick = { alignment = Alignment.TopStart }) { Text("TopStart") }
            Button(onClick = { alignment = Alignment.TopCenter }) { Text("TopCenter") }
            Button(onClick = { alignment = Alignment.TopEnd }) { Text("TopEnd") }
            Button(onClick = { alignment = Alignment.CenterStart }) { Text("CenterStart") }
            Button(onClick = { alignment = Alignment.Center }) { Text("Center") }
            Button(onClick = { alignment = Alignment.CenterEnd }) { Text("CenterEnd") }
            Button(onClick = { alignment = Alignment.BottomStart }) { Text("BottomStart") }
            Button(onClick = { alignment = Alignment.BottomCenter }) { Text("BottomCenter") }
            Button(onClick = { alignment = Alignment.BottomEnd }) { Text("BottomEnd") }

        }
    }
}