package com.example.curso.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.curso.ui.screens.Gato

@Composable
@Preview(showBackground = true)
fun CatCard(
    gato: Gato = Gato(
        nombre = "Nieves",
        color = "Blanco",
        edad = "2",
        peso = "2",
        genero = "macho"
    ),
    go: () -> Unit = {}
) {
    OutlinedCard(
        border = BorderStroke(2.dp, Color.Black),
        modifier = Modifier
            .fillMaxWidth(),
        onClick = { go() }
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Row {
                Text(
                    text = gato.nombre,
                    modifier = Modifier.weight(1f),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Text(text = gato.color, fontStyle = FontStyle.Italic)
            }
            Row {
                Text(text = "${gato.edad} años", modifier = Modifier.weight(1f))
                Text(text = "${gato.peso} kg")
            }
            Row {
                Text(text = gato.genero)
            }
        }
    }
}