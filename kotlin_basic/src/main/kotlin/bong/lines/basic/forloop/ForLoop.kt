package bong.lines.basic.forloop

fun main() {
    forLoopLogic()

    forLoopLogics2()
}

fun forLoopLogic(){
    val items = listOf("apple", "banana", "kiwifruit")

    for (item in items) {
        println(item)
    }
}

fun forLoopLogics2(){
    val items = listOf("apple", "banana", "kiwifruit")
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}
