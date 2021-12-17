package bong.lines.idioms

fun main() {
    var value:String? = "value"

    value = null

    val mapped = value?.let {  } ?: "hahahahhaha"

    println("Good ${mapped} " )
}