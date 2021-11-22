package bong.lines.idioms

fun main() {
    val x: String = "Foo"

    var value: XValue = XValue();

    when (value){
        is XValue -> println("Print value is $x ${value.testValue()}")
    }

}

class XValue {
    fun testValue() :String {

        println("Test!!")

        return "String Value"
    }
}