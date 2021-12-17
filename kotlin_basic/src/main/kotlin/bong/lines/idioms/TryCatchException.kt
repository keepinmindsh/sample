package bong.lines.idioms

fun main() {
    val result = try {
        count()
    } catch (e : Exception){
        throw Exception(e)
    }

    println(result)
}

fun count(): Int {
    return 1000
}
