package bong.lines.basic.collections

fun main() {
    /**
     * These functions return the first and the last element of the collection correspondingly. You can also use them with a predicate; in this case, they return the first or the last element that matches the given predicate.s
     */
    val numbers = listOf(1, -2, 3, -4, 5, -6)            // 1

    val first = numbers.first()                          // 2
    val last = numbers.last()                            // 3

    val firstEven = numbers.first { it % 2 == 0 }        // 4
    val lastOdd = numbers.last { it % 2 != 0 }           // 5

    println(first)

    println(last)

    println(firstEven)

    println(lastOdd)

    println()

    /**
     * These functions work almost the same way with one difference: they return null if there are no matching elements.
     */
    val words = listOf("foo", "bar", "baz", "faz")         // 1
    val empty = emptyList<String>()                        // 2

    val firstOrNull = empty.firstOrNull()                        // 3
    val lastOrNull = empty.lastOrNull()                          // 4

    val firstF = words.firstOrNull { it.startsWith('f') }  // 5
    val firstZ = words.firstOrNull { it.startsWith('z') }  // 6
    val lastF = words.lastOrNull { it.endsWith('f') }      // 7
    val lastZ = words.lastOrNull { it.endsWith('z') }      // 8

    println(firstOrNull)
    println(lastOrNull)
    println(firstF)
    println(firstZ)
    println(lastF)
    println(lastZ)

    println()

    /**
     * count functions returns either the total number of elements in a collection or the number of elements matching the given predicate.
     */
    val totalCount = numbers.count()                     // 2
    val evenCount = numbers.count { it % 2 == 0 }        // 3

    println(totalCount)
    println(evenCount)
}
