package bong.lines.basic.whenexpression

fun main() {
    println(describe(1))

    println(describe("1"))
}

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
