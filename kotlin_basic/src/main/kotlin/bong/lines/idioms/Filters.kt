package bong.lines.idioms

fun main() {
    val valueList = listOf(1,2,3,4,5,6,7,8,9,10)

    val filteredList = valueList.filter { x -> x > 5 }

    println("$filteredList is a List")

    val filteredListValues = valueList.filter { it > 5 }

    println("$filteredListValues is a List")
}