package com.example.curso.kotlintest

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
    flujoDeNumeros.map {
        it * it
    }.filter {
        it % 2 == 0
    }.collect {
        println(it)
    }
}
val flujoDeNumeros: Flow<Int> = flow {
    repeat(60) {
        emit(it + 1)
        delay(1000)
    }
}

val flujoDeLetras: Flow<String> = flow {
    for (c in 'a'..'z') {
        emit(c.toString())
        delay(1000)
    }
}

suspend fun operadoresTest() {
    flujoDeNumeros.map {
        it * it
    }.filter {
        it % 2 == 0
    }.collect {
        println(it)
    }
}