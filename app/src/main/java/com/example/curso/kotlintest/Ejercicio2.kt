package com.example.curso.kotlintest

fun main() {
//    val nombreTienda = "Tienda Pokemon Central"
//    var pokeballs = 10
//
//    println("Nombre: $nombreTienda")
//    println("Inventario inicial: $pokeballs Pokébolas")
//    pokeballs -= 3
//    pokeballs += 15
//    println("Inventario final: $pokeballs Pokebolas")
//
//    Si(true) {
//        println("Hola")
//    }
//
    Mientras(true){
        println("Hola")
    }

    // Intentar cambiar el nombre de la tienda (descomenta la línea siguiente para probar)
    // nombreTienda = "Otra Tienda Pokemon" // Esto genera un error porque 'val' no puede ser reasignado
}



fun Si(condicion: Boolean, f: () -> Unit) {
    if (condicion) {
        f()
    }
}

fun Mientras(condicion: Boolean, f: () -> Unit) {
    while (condicion) {
        f()
    }
}
