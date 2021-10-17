package bong.lines.whileloop

fun main() {
    whileLoopLogic()
}

fun whileLoopLogic(){
    val items = listOf("apple", "banana", "kiwifruit")
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
}
