package bong.lines.idioms

fun main() {
    val valueList = listOf("value@gmail.com", "john@example.com", "bong@gmail.com")

    if("bong@gmail.com" in valueList){
        println(valueList)
    }

    if("bongvalue@gmail.com" in valueList){
        println(valueList)
    }
}