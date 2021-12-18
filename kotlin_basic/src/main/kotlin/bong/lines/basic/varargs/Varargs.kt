package bong.lines.basic.varargs

fun printAll(vararg messages: String) {                            // 1
    for (m in messages) println(m)
}

fun printAllWithPrefix(vararg messages: String, prefix: String) {  // 3
    for (m in messages) println(prefix + m)
}

fun log(vararg entries: String) {
    printAll(*entries)                                             // 5
}

fun main() {
    printAll("Hello", "Hallo", "Salut", "Hola", "你好")                 // 2

    printAllWithPrefix(
        "Hello", "Hallo", "Salut", "Hola", "你好",
        prefix = "Greeting: "                                          // 4
    )

    log("Hello", "Hallo", "Salut", "Hola", "你好")
}
