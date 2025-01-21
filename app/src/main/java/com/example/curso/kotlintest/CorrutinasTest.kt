package com.example.curso.kotlintest

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() = runBlocking {
    launch { // builder de corrutinas que vincula a main con el entorno de corrutinas
        delay(5000L) // funcion de suspención (suspend fun)
        println("Mundo!") // Se imprime despues del retraso
    }
    CoroutineScope(Dispatchers.Default).launch {
        println("Corrutina con launch")
    }
    fetchData()

    val resultado = async {
        fetchData()
    }
    println("Resultado: ${resultado.await()}")
    println("Hola")

    CoroutineScope(Dispatchers.IO).launch {
        val data = fetchData()
        withContext(Dispatchers.Main) {
            println("Datos recibidos: $data")
        }
    }

    val job = CoroutineScope(Dispatchers.Default).launch {
        repeat(10) { i ->
            println("Iteración $i")
            delay(500)
        }
    }
    delay(2000) // Permite que algunas iteraciones se ejecuten
    job.cancel() // Cancela el trabajo
    println("Corrutina cancelada")


}

suspend fun jerarquiaTest() {
    runBlocking {
        val parentJob = launch {
            launch {
                println("Hijo 1 iniciado")
            }
            launch {
                println("Hijo 2 iniciado")
            }
        }
        parentJob.join() // Espera a que todos los hijos terminen
    }
}


suspend fun fetchData(): String {
    delay(1000L) // Simula una operación larga sin bloquear el hilo
    return "Datos cargados"
}


private suspend fun CoroutineScope.ejemplo1() {
    val diferido = async(Dispatchers.Default) {
        cargarDatos()
    }
    println("esperando...")
    println(diferido.await())
}

suspend fun mundo() {
    delay(1000L)
    print("Mundo!")
}


suspend fun cargarDatos(): Int {
    println("cargando...")
    delay(5000L)
    println("cargado!")
    return 42
}