package com.example.curso.ui.navigation.graphs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.example.curso.ui.navigation.rutes.Graph
import com.example.curso.ui.navigation.rutes.Routes
import com.example.curso.ui.navigation.rutes.Rutas

fun NavGraphBuilder.graficoTest(go: (Any) -> Unit) {
    navigation<Graph.GraficoTest>(startDestination = Routes.Destino1) {
        composable<Routes.Destino1> {
            Destino1 { go(Routes.Destino2) }
        }
        composable<Routes.Destino2> {
            Destino2 {go(Routes.Destino3(nombre = "Pepito", edad = 20))}
        }
        composable<Routes.Destino3> {
            val args = it.toRoute<Routes.Destino3>()
            Destino3(nombre = args.nombre ?: "NaN", edad = args.edad ?: -1)
        }
        /**
         * Agregar mas destinos
         * */
    }
}

@Composable
@Preview(showBackground = true)
fun Destino1(go: () -> Unit = {}) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("CONTENIDO1")
        OutlinedButton(onClick = { go() }) { Text("Ir a Destino2") }
    }
}

@Composable
@Preview(showBackground = true)
fun Destino2(go: () -> Unit = {}) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("CONTENIDO2")
        OutlinedButton(onClick = { go() }) { Text("Ir a Destino3") }
    }
}

@Composable
@Preview(showBackground = true)
fun Destino3(nombre: String = "", edad: Int = -1) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("CONTENIDO3")
        Text("Nombre : $nombre")
        Text("Edad : $edad")
    }
}

