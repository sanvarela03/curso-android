package com.example.curso.kotlintest

import kotlinx.coroutines.*
import kotlin.random.Random


data class Pedido(val nombre: String, val tiempoPreparacion: Int)

fun main() = runBlocking {

    val pedidos = listOf(
        Pedido("Pizza Margarita", Random.nextInt(3, 10)),
        Pedido("Hamburguesa con queso", Random.nextInt(3, 10)),
        Pedido("Sushi", Random.nextInt(3, 10)),
        Pedido("Tacos", Random.nextInt(3, 10)),
        Pedido("Ensalada Cesar", Random.nextInt(3, 10))
    )

    println("Iniciando preparacion de pedidos...\n")


    val resultados = pedidos.map { pedido ->
        async {
            prepararPedido(pedido)
        }
    }


    resultados.awaitAll()

    println("\nTodos los pedidos han sido completados. ¡Buen provecho!")
}


suspend fun prepararPedido(pedido: Pedido) {
    println("Preparando ${pedido.nombre} (tiempo estimado: ${pedido.tiempoPreparacion} segundos)...")
    delay(pedido.tiempoPreparacion * 1000L) // Simula el tiempo de preparación
    println("${pedido.nombre} esta listo.")
}
