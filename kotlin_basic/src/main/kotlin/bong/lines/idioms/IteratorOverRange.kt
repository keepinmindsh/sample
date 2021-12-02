package bong.lines.idioms

fun main(){
    for (i in 1..100) {
        println(i)
    }  // closed range: includes 100

    for (i in 1 until 100) {
        println(i)
    } // half-open range: does not include 100

    for (x in 2..10 step 2) {
        println(x)
    }

    for (x in 10 downTo 1) {
        println(x)
    }

    (1..10).forEach {
        run {
            println(it)
        }
    }
}