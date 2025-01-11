package com.example.curso.kotlintest


fun main() {
    val temperatura = 25

    if (temperatura < 0) {
        println("Hace frío extremo.")
    } else if (temperatura in 0..10) {
        println("Hace frío.")
    } else if (temperatura in 11..20) {
        println("Hace fresco.")
    } else if (temperatura in 21..30) {
        println("Hace calor.")
    } else {
        println("Hace calor extremo.")
    }

    val recomendacion = when (temperatura) {
        in 0..10 -> "Usa abrigo."
        in 11..20 -> "Usa suéter."
        in 21..30 -> "Usa ropa ligera."
        else -> "Usa ropa muy ligera y protección solar."
    }

    println("Recomendación: $recomendacion")
}
