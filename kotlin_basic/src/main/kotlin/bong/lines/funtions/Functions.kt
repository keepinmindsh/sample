package bong.lines.funtions


fun sum(a: Int, b: Int): Int {
    return a + b
}

fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}
fun sum1(a: Int, b: Int): Unit {
    print("sum of $a and $b is ${a + b}")
}

fun sum2(a: Int, b: Int) = a + b

fun sum3(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}

fun main(){
    println(sum(1, 2))

    println(sum1(1,4))

    println(sum2(5,4))

    println(sum3(9,4))

    print(printSum(100, 100));
}
