package bong.lines.basic.range

fun main() {

    val i = 1
    if (i in 1..4) { // equivalent of 1 <= i && i <= 4
        print(i)
    }

    println()

    for (i in 1..4) print(i)

    println()

    // 4부터 시작해서 역순으로 1까지 Loop를 돈다.
    for (i in 4 downTo 1) print(i)

    println()

    // step을 수만큼 건너뛰면서 출력된다.
    for (i in 1..8 step 2) print(i)
    println()
    for (i in 8 downTo 1 step 2) print(i)

    println()

    // 10 전까지 표시된다.
    for (i in 1 until 10) {       // i in [1, 10), 10 is excluded
        print(i)
    }

    println()

    // TODO 해당 부분 이해되지 않음! - https://kotlinlang.org/docs/ranges.html#range
    //val versionRange = Version(1, 11)..Version(1, 30)
    //println(Version(0, 9) in versionRange)
    //println(Version(1, 20) in versionRange)


    for (i in 1..10) print(i)

    println()

    for (i in (1..4).reversed()) print(i)

    println()

    println((1..10).filter { it % 2 == 0 })
}