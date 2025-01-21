package com.example.curso.ui.navigation.graphs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.curso.ui.navigation.rutes.Graph
import com.example.curso.ui.navigation.rutes.Rutas
import com.example.curso.ui.screens.AlineacionEnCaja
import com.example.curso.ui.screens.AlineacionHorizontal
import com.example.curso.ui.screens.AlineacionVertical
import com.example.curso.ui.screens.CatDetail
import com.example.curso.ui.screens.Contenedor
import com.example.curso.ui.screens.Contenedores
import com.example.curso.ui.screens.FormularioAgregarGato
import com.example.curso.ui.screens.NumeroMayor


@OptIn(ExperimentalLayoutApi::class)
fun NavGraphBuilder.graficoClases(go: (Any) -> Unit) {
    navigation<Graph.GraficoClases>(startDestination = Rutas.Clase1) {
        composable<Rutas.Clase1> {
            Column {
                Contenedores()
                Button(onClick = { go(Rutas.Clase2) }) {
                    Text("Ir a clase 2")
                }
            }
        }
        composable<Rutas.Clase2> {
            Contenedores(Contenedor.FILA)
        }
        composable<Rutas.Clase3> {
            Contenedores(Contenedor.CAJA)
        }
        composable<Rutas.Clase4> {
            NumeroMayor()
        }
        composable<Rutas.Clase5> {
            AlineacionHorizontal()
        }
        composable<Rutas.Clase6> {
            AlineacionVertical()
        }
        composable<Rutas.Clase7> {
            AlineacionEnCaja()
        }
        composable<Rutas.Clase8> {
            FormularioAgregarGato(go = go)
        }
        composable<Rutas.Cat> {
            CatDetail()
        }
    }
}