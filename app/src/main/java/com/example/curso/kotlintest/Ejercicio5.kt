package com.example.curso.kotlintest

fun totalPrices(prices: List<Int>, selector: (Int) -> Boolean): Int {
    var sum = 0
    for (price in prices) {
        if (selector(price)) {
            sum += price
        }
    }
    return sum
}

fun main() {
    val prices = listOf(50, 150, 200, 30, 70, 120)

    println("Suma total: ${totalPrices(prices) { true }}")
    println("Suma de precios mayores a 100: ${totalPrices(prices) { it > 100 }}")
    println("Suma de precios menores o iguales a 100: ${totalPrices(prices) { it <= 100 }}")
}
