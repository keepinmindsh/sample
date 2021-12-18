package bong.lines.patterns.bridge.abstract

import bong.lines.patterns.bridge.inf.Implementer

abstract class Abstraction(val implementer: Implementer) {
    abstract fun workWithImplementer()
}
