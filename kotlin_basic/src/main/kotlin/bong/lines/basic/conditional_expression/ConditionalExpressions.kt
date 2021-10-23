package bong.lines.basic.conditional_expression

fun main() {
    println(maxOf1(10, 20))

    println(maxOf2(10, 20))
}

fun maxOf1(a: Int, b:Int) = if ( a > b ) a else b

fun maxOf2(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}
