package bong.lines.funtions

fun main() {
    print(sum(100, 100));

    print(printSum(100, 100));
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}
