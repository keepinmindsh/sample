package bong.lines.basic.string_templates

fun main() {
    var a = "1"

    var s1 = "a is $a"

    a = "2"

    val s2 = "${s1.replace("is", "was")}, but now is $a"

    println(s2)
}
