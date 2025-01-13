package com.example.curso

import android.os.Bundle
// ...
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.curso.kotlintest.Contador
import com.example.curso.kotlintest.DirectRecomposition
import com.example.curso.ui.navigation.graphs.graficoClases
import com.example.curso.ui.components.NavegacionInferior
import com.example.curso.ui.navigation.rutes.Graph
import com.example.curso.ui.theme.CursoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoTheme {
//                DirectRecomposition()
                Contador()
//                Clases()
//                SplitView()
//                FormularioAgregarGato()

            }
        }
    }
}


@Composable
fun Clases() {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { NavegacionInferior() { navController.navigate(it) } }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Graph.GraficoClases,
            modifier = Modifier.padding(innerPadding)
        ) {
            graficoClases { navController.navigate(it) }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier.padding(24.dp) // Modificador
    )
}








