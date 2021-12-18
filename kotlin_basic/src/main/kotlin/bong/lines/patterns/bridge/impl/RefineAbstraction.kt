package bong.lines.patterns.bridge.impl

import bong.lines.patterns.bridge.abstract.Abstraction
import bong.lines.patterns.bridge.inf.Implementer

class RefineAbstraction(implementer: Implementer) : Abstraction(implementer) {
    override fun workWithImplementer() {
        implementer.implement()
    }
}
