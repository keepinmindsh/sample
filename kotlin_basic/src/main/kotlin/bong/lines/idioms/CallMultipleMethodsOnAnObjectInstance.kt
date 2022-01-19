package bong.lines.idioms

class Turtle {
    fun penDown(){
        println("pen Down")
    }
    fun penUp(){
        println("pen Up")
    }
    fun turn(degrees: Double){
        println(degrees)
    }
    fun forward(pixels: Double){
        println(pixels)
    }
}

fun main() {
    val myTurtle = Turtle()
    with(myTurtle) { //draw a 100 pix square
        penDown()
        for (i in 1..4) {
            forward(100.0)
            turn(90.0)
        }
        penUp()
    }
}