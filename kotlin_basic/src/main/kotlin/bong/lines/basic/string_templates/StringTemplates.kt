package bong.lines.basic.string_templates

fun main() {
    StringTemplate()

    forLoopForEachStringCharacter()

    applyUppercase()

    stringLiteral()

    trimMargin()

    displayPrice()
}

private fun StringTemplate() {
    var a = "1"

    var s1 = "a is $a"

    a = "2"

    val s2 = "${s1.replace("is", "was")}, but now is $a"

    println(s2)
}

fun forLoopForEachStringCharacter(){
    val str = "abcd 123"

    for (c in str) {
        println(c)
    }
}

fun applyUppercase(){
    val str = "abcd"
    println(str.uppercase()) // Create and print a new String object
    println(str) // the original string remains the same
}

fun stringLiteral(){
    val text = """
    for (c in "foo")
        print(c)
"""

    println(text)
}

fun trimMargin(){
    val text = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()

    println(text)
}

fun displayPrice(){
    val price = """
${'$'}_9.99
"""

    println(price)
}