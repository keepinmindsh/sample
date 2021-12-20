package bong.lines.basic.forloop

fun main() {
    forLoopLogic()

    forLoopLogics2()

    val cakes = listOf("carrot", "cheese", "chocolate")

    for (cake in cakes) {                               // 1
        println("Yummy, it's a $cake cake!")
    }


    var cakesEaten = 0
    var cakesBaked = 0

    while (cakesEaten < 5) {                    // 1
        eatACake()
        cakesEaten ++
    }

    do {                                        // 2
        bakeACake()
        cakesBaked++
    } while (cakesBaked < cakesEaten)
}

fun eatACake() = println("Eat a Cake")
fun bakeACake() = println("Bake a Cake")

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
