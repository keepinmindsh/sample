package bong.lines.typecheckorcast

fun getStringLength1(obj: Any): Int? {
    if (obj is String) {
        // `obj` is automatically cast to `String` in this branch
        return obj.length
    }

    // `obj` is still of type `Any` outside of the type-checked branch
    return null
}

fun getStringLength2(obj: Any): Int? {
    // `obj` is automatically cast to `String` on the right-hand side of `&&`
    if (obj is String && obj.length > 0) {
        return obj.length
    }

    return null
}

fun main() {
    fun printLength(obj: Any) {
        println("Getting the length of '$obj'. Result: ${getStringLength1(obj) ?: "Error: The object is not a string"} ")
    }

    printLength("Incomprehensibilities")
    printLength(1000)
    printLength(listOf(Any()))

    fun printLength2(obj: Any) {
        println("Getting the length of '$obj'. Result: ${getStringLength2(obj) ?: "Error: The object is not a string"} ")
    }

    printLength2("Incomprehensibilities")
    printLength2(1000)
    printLength2(listOf(Any()))
}
