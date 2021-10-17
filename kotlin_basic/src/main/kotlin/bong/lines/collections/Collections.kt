package bong.lines.collections

fun main() {
    collectionsWithForIn()

    collectionWithIn()

    collectionWithFilterMapLoop()
}

fun collectionsWithForIn(){
    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println(item)
    }
}

fun collectionWithIn(){
    val items = setOf("apple", "banana", "kiwifruit")
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }
}


fun collectionWithFilterMapLoop(){
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { println(it) }
}
