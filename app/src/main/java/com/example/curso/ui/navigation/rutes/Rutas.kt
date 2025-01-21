package com.example.curso.ui.navigation.rutes

import com.example.curso.ui.screens.Gato
import com.example.curso.ui.states.CatState
import kotlinx.serialization.Serializable

@Serializable
sealed class Rutas(val ruta: String) {
    @Serializable
    object Clase1 : Rutas("Clase1")

    //    @Serializable
//    data class Clase2(val p: String, val q: String)
    @Serializable
    object Clase2 : Rutas("Clase2")

    @Serializable
    object Clase3 : Rutas("Clase3")

    @Serializable
    object Clase4 : Rutas("Clase4")

    @Serializable
    object Clase5 : Rutas("Clase5")

    @Serializable
    object Clase6 : Rutas("Clase6")

    @Serializable
    object Clase7 : Rutas("Clase7")

    @Serializable
    object Clase8 : Rutas("Clase8")

    @Serializable
    object Destino1 : Rutas("Destino1")

    @Serializable
    data class Cat(
        var nombre: String = "",
        var genero: String = "",
        var edad: String = "",
        var peso: String = "",
        var color: String = "",
    ) : Rutas("Gatos") {
        fun toCatState(): CatState {
            return CatState(
                nombre = nombre,
                genero = genero,
                edad = edad,
                peso = peso,
                color = color
            )
        }

        fun toParams(gato: Gato): Cat {
            nombre = gato.nombre
            genero = gato.genero
            edad = gato.edad
            peso = gato.peso
            color = gato.color

            return this
        }
    }


}

sealed class Graph {
    @Serializable
    data object GraficoClases : Graph()

    @Serializable
    data object GraficoTest : Graph()
}


sealed class Routes {
    @Serializable
    object Destino1 : Routes()

    @Serializable
    object Destino2 : Routes()

    @Serializable
    data class Destino3(
        val nombre: String?,
        val edad: Int?
    ) : Routes()
}