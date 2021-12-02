package bong.lines.idioms

fun main(){

    var map  = hashMapOf<String, String>("a" to "a", "b" to "good!")

    for ((k, v) in map) {
        println("$k -> $v")
    }
}