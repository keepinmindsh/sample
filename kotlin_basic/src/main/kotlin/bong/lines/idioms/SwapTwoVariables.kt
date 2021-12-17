package bong.lines.idioms

fun main() {
    var a = 1
    var b = 2
    a = b.also { b = a }

    println("Answer is ${a}")
}