package bong.lines.idioms

fun main() {
    val values: MutableMap<String, String> = mutableMapOf();
    val email = values["email"] ?: throw IllegalStateException("Email is missing!")

    println(email)
}
