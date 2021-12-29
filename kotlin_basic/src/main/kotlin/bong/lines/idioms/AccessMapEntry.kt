package bong.lines.idioms


data class Person(var name: String, var lastName: String, var age: Int)

val nameTable = mutableMapOf<String, Person>()
val example = Person("Josh", "Cohen", 24)

fun main() {
    var map = hashMapOf<String, String>()

    // TODO - 왜 이건 제대로 동작하지 않는가? - var map:Map<String, String> map = hashMapOf<String, String>()
    //map["key"] = "TestValue"

    var value:String = "value";

    map["key"] = value;

    nameTable["person1"] = example

    for((key, value) in nameTable){
        println(value.age)
    }
}
