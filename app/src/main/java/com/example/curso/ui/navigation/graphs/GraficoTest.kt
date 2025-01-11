package com.example.curso.ui.navigation.graphs

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.curso.ui.navigation.rutes.Graph
import com.example.curso.ui.navigation.rutes.Routes
import com.example.curso.ui.navigation.rutes.Rutas

fun NavGraphBuilder.graficoTest(go: (Any) -> Unit) {
    navigation<Graph.GraficoTest>(startDestination = Routes.Destino1) {
        composable<Routes.Destino1> {
            Column {
                Text("CONTENIDO1")
            }
        }
        composable<Routes.Destino2> {
            Column {
                Text("CONTENIDO2")
            }
        }
        /**
         * Agregar mas destinos
         * */
    }
}