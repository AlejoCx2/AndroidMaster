package com.alejocx2.androidmaster.sintaxis

/**
 * Variables
 */

fun main() {

    // No siempre es necesario especificar el tipo
    // Tambien esta el tipo Any
    val name = "Alejandro"

    val age: Int = 25
    val example: Long = 342342342342
    val floatExample: Float = 12.45f
    val doubleExample: Double = 12.3453345

    val charExample: Char = 'a' //Comillas simples y solo un caracter
    val stringExample: String = "0sdasda 5767" // Comillas dobles

    val boolExample1: Boolean = true
    val boolExample2: Boolean = false

    /**
     * Hay VALORES y VARIABLES
     * Las variables son mutables miestras que los valores son constantes
     */

    // age = 26
    var newAge = 21
    newAge = 25

    println("Hola $name")

    myFuncion()
    var nextAge = myFuncion(newAge)
    println("La siguiente edad es: $nextAge")

    var month = 4
    whenFunction(month, "XD")

    nulabilidad(null)
    arreglosYListas()

}

fun myFuncion(valor: Int = 0): Int {
    println("Ingresaste el valor de: $valor")
    return valor + 1
}

fun whenFunction(month: Int, other: Any) {

    when (month) {
        1 -> println("Mes 1")
        2 -> println("Mes 2")
        3, 4 -> println("Mes 3 y 4")
        5 -> println("Mes 5")
        6 -> println("Mes 6")
        in 7..8 -> {
            println("Mes 7")
            println("Mes 8")
        }

        9 -> println("Mes 9")
        10 -> println("Mes 10")
        11 -> {
            println("Mes 11")
            println("Mas cosas xd")
        }

        12 -> println("Mes 12")
        else -> println("No valido")
    }

    when (other) {
        is Int -> println("Entero")
        is String -> println("Cadena de texto")
        is Boolean -> println("Booleano")
        else -> println("Otro tipo de valor")
    }

}

fun nulabilidad(value: String?) {
    var vacio: String? = value
    println(vacio?.get(2) ?: "Esta vacio")
}

fun arreglosYListas() {

    // Los arreglos tienen un tamano fijo
    val weekDays = arrayOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes")
    println(weekDays.size)
    println(weekDays[0])

    for (pos in weekDays.indices) {
        println("Pase por $pos")
    }

    // Las listas si son mutables y de tamanos variables

    val readOnly: List<String> = listOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes")
    val example = readOnly.filter { it.contains("a") }
    println(example)
    readOnly.forEach { weekDay -> println(weekDay) }

    var weekEnds:MutableList<String> = mutableListOf("Sabado", "Domingo")
    weekEnds.add(0,"Devday")
    println(weekEnds)

    println(weekEnds.isEmpty())

}
