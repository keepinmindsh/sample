package bong.lines.idioms

import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val stream = Files.newInputStream(Paths.get("D:\\Users\\dream\\test\\logs\\s_starter\\logback.log"))
    stream.buffered().reader().use { reader ->
        println(reader.readText())
    }
}