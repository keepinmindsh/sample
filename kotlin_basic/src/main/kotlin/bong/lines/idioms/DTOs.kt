package bong.lines.idioms

data class Sample(val name : String, var age : Int){

    var testValue : Int = 0;
}

data class Data1(val name : String)
data class Data2(var name : String)

fun main() {
    val sample = Sample("Hong Gil Dong", 50)

    sample.testValue = 20

    println(sample.testValue)

    val data = Data1("GilDong")

    // we cannot reassign variables with "val"
    println(data.name)
    println(data.toString())

    // copy object from data with new assigned value
    var data1 = data.copy("Gil dong1")

    println(data.hashCode())
    println(data.toString())
    println(data1.hashCode())
    println(data1.toString())

    // TODO - when copy data from dataVar1, I thought it is deep copy, because hashcode between two objects was different. but it not sure. need to check it more
    val dataVar1 = Data1("A")
    var dataVar2 = dataVar1.copy("B")

    println(dataVar1.hashCode())
    println(dataVar1.toString())

    println(dataVar2.hashCode())
    println(dataVar2.toString())

    // Destructuring Value
    // 변수를 data class 에서 가져올 때, 해당 객채에서 각각의 변수를 구조 분해 할당 방식으로 아래 코드와 같이 가져올 수 있다. 우리나라 말로는 좀 어려운 뜻으로 느껴지네..
    val ( a, b ) = sample
    println(a)
    println(b)
}