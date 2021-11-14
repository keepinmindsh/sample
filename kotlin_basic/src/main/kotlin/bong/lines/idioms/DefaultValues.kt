package bong.lines.idioms

fun main() {
    println(foo( b = "1241243"))
}

fun foo(a : Int = 10, b: String = ""):String{
    return "$a is $b";
}