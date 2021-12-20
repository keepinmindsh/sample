package bong.lines.basic.infixfunctions

fun main() {

    infix fun Int.times(str: String) = str.repeat(this)     // 1
    println(2 times "Bye ")                                    // 2

    val pair = "Ferrari" to "Katrina"                          // 3
    println(pair)

    infix fun String.onto(other: String) = Pair(this, other)   // 4
    val myPair = "McLaren" onto "Lucas"
    println(myPair)

    // TODO 아래의 코드에 대한 활용 방안 공부필요
    val sophia = Person("Sophia")
    val claudia = Person("Claudia")
    val claudia1 = Person("Claudia1")
    val claudia2 = Person("Claudia2")

    sophia likes claudia
    sophia likes claudia1
    sophia likes claudia2

    sophia.likedPeople

    for(item : Person in sophia.likedPeople) println("${item.name}")
}

class Person(val name: String) {
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) { likedPeople.add(other) }  // 6
}
