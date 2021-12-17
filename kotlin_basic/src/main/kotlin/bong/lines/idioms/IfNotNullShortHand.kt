package bong.lines.idioms

import java.io.File


fun main() {
    val files = File("Test").listFiles()

    println(files?.size)
}