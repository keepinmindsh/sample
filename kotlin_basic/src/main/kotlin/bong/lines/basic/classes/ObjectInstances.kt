package bong.lines.basic.classes

val helloWorld = object {
    val hello = "Hello"
    val world = "World"
    // object expressions extend Any, so `override` is required on `toString()`
    override fun toString() = "$hello $world"
}

open class A(x: Int) {
    public open val y: Int = x
}

interface B {
    fun calculate() : Int
}

val ab: B = object : A(1), B {
    override val y = 15

    override fun calculate(): Int = y * 400
}

class C {
    private fun getObject() = object {
        val x: String = "x"
    }

    fun printX() {
        println(getObject().x)
    }
}

fun main() {
    println("Value is $helloWorld")

    println("다중 Super Type 설정 가능")

    println("${ab.calculate()}")

    println("${C().printX()}")

    // TODO - https://kotlinlang.org/docs/object-declarations.html#using-anonymous-objects-as-return-and-value-types

}

