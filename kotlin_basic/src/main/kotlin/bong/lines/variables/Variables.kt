package bong.lines.variables

fun main() {
    val a: Int = 1  // immediate assignment
    val b = 2   // `Int` type is inferred
    val c: Int  // Type required when no initializer is provided
    c = 3       // deferred assignment

    print(a)
    print(b)
    print(c)

    incrementX()
}

val PI = 3.14
var x = 0

fun incrementX() {
    x += 1
}



