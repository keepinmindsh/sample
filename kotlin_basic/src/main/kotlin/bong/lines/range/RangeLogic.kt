package bong.lines.range

fun main() {
    rangeLogic()

    rangeLogic2()

    rangeWithIterator()

    rangeWithProgression()
}

fun rangeLogic(){
    val x = 9
    var y = 10

    if(x in 1..y+1){
        println("fits in range")
    }

}

fun rangeLogic2(){
    val list = listOf("a", "b", "c")

    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range, too")
    }
}

fun rangeWithIterator(){
    for (x in 1..5) {
        print(x)
    }
}

fun rangeWithProgression(){
    for (x in 1..10 step 2) {
        print(x)
    }
    println()
    for (x in 9 downTo 0 step 3) {
        print(x)
    }
}
