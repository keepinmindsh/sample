package bong.lines.basic.variables

fun sample1() {
    val a: Int = 1  // immediate assignment
    val b = 2   // `Int` type is inferred
    val c: Int  // Type required when no initializer is provided
    c = 3       // deferred assignment

    print(a)
    print(b)
    print(c)

    incrementX()
}

fun sample2() {
    var x = 5 // `Int` type is inferred
    x += 1
}

val PI = 3.14
var x = 0

fun incrementX() {
    x += 1
}

class Address {
    var name: String = "Holmes, Sherlock"
    var street: String = "Baker"
    var city: String = "London"
    var state: String? = null
    var zip: String = "123456"
}

fun copyAddress(address: Address): Address {
    val result = Address() // there's no 'new' keyword in Kotlin
    result.name = address.name // accessors are called
    result.street = address.street
    // ...
    return result
}

fun main(){
    sample1()

    sample2()

    incrementX()

    println("Value is ${copyAddress(Address()).city}")
}
