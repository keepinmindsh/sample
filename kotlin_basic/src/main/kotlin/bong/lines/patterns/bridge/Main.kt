package bong.lines.patterns.bridge

import bong.lines.patterns.bridge.abstract.Abstraction
import bong.lines.patterns.bridge.impl.ConcreteImplementer1
import bong.lines.patterns.bridge.impl.RefineAbstraction

fun main() {
    var abstraction: Abstraction = RefineAbstraction(ConcreteImplementer1())

    abstraction.workWithImplementer()
}
