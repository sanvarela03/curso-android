package com.example.curso.kotlintest

fun main() {
    val pokemonCreado = crearPokemon("Pikachu", "electrico", "lanzar rayos")
    println(pokemonCreado)
}

fun crearPokemon(
    nombre: String,
    tipo: String,
    poderEspecial: String
): String =
    "Has creado a $nombre, un Pokemon de tipo $tipo con el poder especial de $poderEspecial"

