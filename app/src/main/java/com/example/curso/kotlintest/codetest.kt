package com.example.curso.kotlintest

//fun suma(a: Int, b: Int): Int {
//    return a + b
//}

fun variables() {
    val a: Int = 1 // Asignacion inmediata
    val b = 2 // El tipo de la variable se infiere por su valor inicial, en este caso "Int"

    val c: Int // Cuando no se inicializa es necesario definir su tipo
    c = 3 // Asignacion diferida, a partir de este punto no se asignar otro valor


    var x = 5 // Se infiere su tipo por su valor inicial, "Int"
    x += 2
    val r = a + b + c;
}

fun suma(a: Int, b: Int) = a + b
fun testSuma() {
    val a = 2
    val b = 3
    println(" Suma de $a + $b = ${suma(a, b)}")
}

fun test() {
//    testSuma()


    var a = 1
    val s1 = "a es $a"

    a = 2
    val s2 = "${s1.replace("es", "era")}, pero ahora es $a"
    println(s1)
    println(s2)

    maxDe(1, 2)


    val x = 3
    when (x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        else -> print("nose")
    }


    var nombre: String? = "Pepito"
    nombre = null // Ok

    println(nombre)

}

//fun maxDe(a: Int, b: Int): Int {
//    if (a > b) {
//        return a
//    } else {
//        return b
//    }
//}
// En kotlin no existe el operador ternario, (a > b) ? a : b
fun maxDe(a: Int, b: Int) = if (a > b) a else b

fun llamadasSeguras() {
    var lista: MutableList<String?>? = mutableListOf<String?>("a", "b", "c", "d")
    lista?.add("e") // if(lista != null) lista.add("e")
    lista?.add(null)
    lista?.add(null)
    lista = null
    val longitud = lista?.size ?: -1 //val longitud = if(lista != null) lista.size else -1
    println(longitud)
}

fun aleatorioTest() {
    val aleatorio = (0..100).random()
    println(aleatorio)
}

//class Persona constructor(nombre: String){ /*...*/ }
//class Persona(nombre: String){ /*...*/ }
open class Persona(
    val nombre: String,
    val apellido: String,
    var esEmpleado: Boolean = true
) {}

val peter = Persona(nombre = "Peter", apellido = "Parker")


open class Padre(val p: Int)
class Hijo(p: Int) : Padre(p)


open class Figura {
    open fun dibujar() {}
}

class Circulo() : Figura() {
    override fun dibujar() {}
}


fun funcionA(funcionB: () -> Unit) {
    //TODO : funcionB, es cualquier funcion que no tenga argumentos y no retorne nada
}

fun main() {
//    val a = 2.0
//    val b = 3.0
//    val n = 1000
//    println("Resultado: ${integral(f = { x -> x * x }, a = a, b = b, n = n)}")

    hasmapTest()
}

fun integral(f: (Double) -> (Double), a: Double, b: Double, n: Int): Double {
    val dx = (b - a) / n
    var sum = 0.0
    var x = a
    while (x < b) {
        sum += f(x) * dx
        x += dx
    }
    return sum
}

fun rangosTest() {
    println(-4 in -3..10) // false
    val r = 50..100
    println(51 in r) // true
    val a = 3
    val b = 7
    val c = 3
    println(c in a..b) // true
}

fun listasTest() {
    val listaInmutable = listOf("a", "b", "c")
    val listaMutable = mutableListOf("a", "b", "c")

    listaMutable.add("d")
    //listaInmutable.add("d") //error
}

fun hasmapTest() {
    val hashMap = hashMapOf(1 to "a", 2 to "b", 3 to "c")

    hashMap[4] = "d"

    println(hashMap)
}



