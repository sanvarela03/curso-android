package com.example.curso.kotlintest

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch { // builder de corrutinas que vincula a main con el entorno de corrutinas
        delay(5000L) // funcion de suspención (suspend fun)
        println("Mundo!") // Se imprime despues del retraso
    }
    println("Hola")
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