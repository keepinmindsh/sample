package bong.lines.basic.classes


fun main() {

    var rectangle = Rectangle(5.0, 10.0);

    println("The parameter is ${rectangle.perimeter}")

    val sample = Sample("Good");

    println("Value is ${sample.firstName}")

    val sample2 = Sample2("Name")

}

class Sample constructor(firstName : String){
    val firstName = firstName
}

class Sample2(firstName: String){
    val firstProperty = "First property: $firstName".also(::println)

    init {
        println("First initializer block that prints $firstName")
    }

    val secondProperty = "Second property: ${firstName.length}".also(::println)

    init {
        println("Second initializer block that prints ${firstName.length}")
    }
}