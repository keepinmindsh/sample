package bong.lines.idioms

fun arrayOfMinusOnes(size: Int): IntArray {
    return IntArray(size).apply { fill(-1) }
}

fun main() {
    println(arrayOfMinusOnes(100))
}