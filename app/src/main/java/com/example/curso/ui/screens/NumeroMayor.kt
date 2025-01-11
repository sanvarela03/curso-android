package com.example.curso.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NumeroMayor() {
    var a by remember { mutableIntStateOf((0..100).random()) }
    var b by remember { mutableIntStateOf((0..100).random()) }
    var msg by remember { mutableStateOf("") }
    var color by remember { mutableStateOf(Color.Red) }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(50.dp)
        ) {
            Text("Escoge el número mayor", fontSize = 30.sp, fontWeight = FontWeight.Bold)
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Button(
                    onClick = {
                        if (a >= b) {
                            msg = "Correcto !"
                            color = Color.Green
                        } else {
                            msg = "Incorrecto !"
                            color = Color.Red
                        }
                        a = (0..100).random()
                        b = (0..100).random()
                    }
                ) {
                    Text("$a")
                }
                Button(
                    onClick = {
                        if (b >= a) {
                            msg = "Correcto !"
                            color = Color.Green
                        } else {
                            msg = "Incorrecto !"
                            color = Color.Red
                        }
                        a = (0..100).random()
                        b = (0..100).random()
                    }
                ) {
                    Text("$b")
                }
            }
            Text(msg, color = color, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}