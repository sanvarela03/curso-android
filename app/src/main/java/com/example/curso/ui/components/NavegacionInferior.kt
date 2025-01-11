package com.example.curso.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.curso.ui.navigation.rutes.Rutas

@Composable
fun NavegacionInferior(go: (Any) -> Unit) {
    val scrollState = rememberScrollState()
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary,
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
//                .background(Color.Red)
                .horizontalScroll(scrollState)
        ) {
            var selected by rememberSaveable { mutableStateOf(false) }
            NavItem("Clase 1") { go(Rutas.Clase1) }
            NavItem("Clase 2") { go(Rutas.Clase2) }
            NavItem("Clase 3") { go(Rutas.Clase3) }
            NavItem("Clase 4") { go(Rutas.Clase4) }
            NavItem("Clase 5") { go(Rutas.Clase5) }
            NavItem("Clase 6") { go(Rutas.Clase6) }
            NavItem("Clase 7") { go(Rutas.Clase7) }
            NavItem("Clase 8") { go(Rutas.Clase8) }

        }

    }
}

@Composable
fun NavItem(text: String = "NaN", navigateTo: () -> Unit) {
    var selected by rememberSaveable { mutableStateOf(false) }
    Text(
        text = text,
        modifier = Modifier
            .padding(10.dp)
            .clickable(onClick = {
                selected = if (selected) !selected else !selected
                navigateTo()
            }),
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = Color.Black
    )
}