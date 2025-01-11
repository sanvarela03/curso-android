fun main() {

    val productos = listOf(5, 12, 8, 15, 20, 7, 30)

    var total = 0
    for (precio in productos) {
        total += precio
    }
    println("El total de todos los productos es: $total")

    println("Productos cuyo precio es mayor a 10:")
    var i = 0
    while (i < productos.size) {
        if (productos[i] > 10) {
            println(productos[i])
        }
        i++
    }
}
