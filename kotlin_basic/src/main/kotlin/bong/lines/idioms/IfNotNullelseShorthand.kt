package bong.lines.idioms

import java.io.File

fun main() {
    val files = File("C:\\Users\\shjeong-PC\\Downloads").listFiles();

    println(files?.size ?: "empty")
}