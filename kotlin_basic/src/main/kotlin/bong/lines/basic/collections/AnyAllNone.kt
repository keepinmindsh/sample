package bong.lines.basic.collections

fun main() {

    // Function any returns true if the collection contains at least one element that matches the given predicate.
    val numbers = listOf(1, -2, 3, -4, 5, -6)            // 1

    val anyNegative = numbers.any { it < 0 }             // 2

    val anyGT6 = numbers.any { it > 6 }                  // 3

    println(numbers)

    println(anyNegative)

    println(anyGT6)

    // Function all returns true if all elements in collection match the given predicate.
    val allEven = numbers.all { it % 2 == 0 }            // 2

    val allLess6 = numbers.all { it < 6 }                // 3

    println(allEven)

    println(allLess6)

    // Function none returns true if there are no elements that match the given predicate in the collection.
    val allEvenNone = numbers.none { it % 2 == 1 }           // 2

    val allLess6None = numbers.none { it > 6 }               // 3

    println(allEvenNone)

    println(allLess6None)
}
