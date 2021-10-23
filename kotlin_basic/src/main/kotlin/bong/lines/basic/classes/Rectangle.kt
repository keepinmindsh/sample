package bong.lines.basic.classes

class Rectangle (var height: Double, var length: Double) : Shape() {
    var perimeter = (height + length) * 2
}
