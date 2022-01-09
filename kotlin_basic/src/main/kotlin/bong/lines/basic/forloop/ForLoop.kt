package bong.lines.basic.forloop

fun main() {
    forLoopLogic()

    forLoopLogic2()

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


    forLoopLogic3()

    println()

    forLoopLogic4()

    println()

    forLoopLogic5()
}

fun eatACake() = println("Eat a Cake")
fun bakeACake() = println("Bake a Cake")

fun forLoopLogic(){
    val items = listOf("apple", "banana", "kiwifruit")

    for (item in items) {
        println(item)
    }
}

fun forLoopLogic2(){
    val items = listOf("apple", "banana", "kiwifruit")
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}

fun forLoopLogic3(){
    var index = 30
    for ( i in 1..index)
        print(i)
}

fun forLoopLogic4(){
    var index = 30
    for ( i in 1..index step 3)
        print(i)
}

fun forLoopLogic5(){
    var index = 30
    for ( i in index downTo 1 step 2)
        print(i)
}