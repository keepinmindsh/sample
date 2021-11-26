package bong.lines.idioms


fun main() {
    val map = mapOf("a" to 1, "b" to 2 , "c" to 3)

    for (item in map){
        println("${item.key} is ${item.value}")
    }
}