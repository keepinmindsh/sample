package bong.lines.basic.range

fun main() {
    rangeLogic()

    rangeLogic2()

    rangeWithIterator()

    rangeWithProgression()

    println()

    rangeWithClass()
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

fun rangeWithClass(){
    val versionRange = Version(1, 11)..Version(1, 30)
    println(Version(0, 9) in versionRange)
    println(Version(1, 20) in versionRange)
}

class Version(val major: Int, val minor: Int): Comparable<Version> {
    override fun compareTo(other: Version): Int {
        if (this.major != other.major) {
            return this.major - other.major
        }
        return this.minor - other.minor
    }
}