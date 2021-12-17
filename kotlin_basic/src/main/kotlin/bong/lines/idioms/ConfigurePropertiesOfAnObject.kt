package bong.lines.idioms

class Rectangle {
    var length: Int? = null
    var breadth: Int? = null
    var color: Int? = null
}

// TODO 이거 공부하자 - https://medium.com/@limgyumin/%EC%BD%94%ED%8B%80%EB%A6%B0-%EC%9D%98-apply-with-let-also-run-%EC%9D%80-%EC%96%B8%EC%A0%9C-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94%EA%B0%80-4a517292df29

val myRectangle = Rectangle().apply {
    length = 4
    breadth = 5
    color = 0xFAFAFA
}

fun main() {

    myRectangle.breadth
}