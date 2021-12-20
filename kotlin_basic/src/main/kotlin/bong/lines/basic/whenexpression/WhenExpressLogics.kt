package bong.lines.basic.whenexpression

fun main() {
    println(describe(1))

    println(describe("1"))


    println(whenAssign("Hello"))
    println(whenAssign(3.4))
    println(whenAssign(1))
    println(whenAssign(MyClass()))
}

fun whenAssign(obj: Any): Any {
    val result = when (obj) {                   // 1
        1 -> "one"                              // 2
        "Hello" -> 1                            // 3
        is Long -> false                        // 4
        else -> 42                              // 5
    }
    return result
}

class MyClass

// Object로 파라미터를 받아 when 절에서 타입과 값에 따라 체크가 가능함.
fun describe(obj: Any): String =
    when (obj) {
        1          -> "One"
        "1"        -> "StringOne"
        "Hello"    -> "Greeting"
        is Long    -> "Long"
        !is String -> "Not a string"
        else       -> "Unknown"
    }
