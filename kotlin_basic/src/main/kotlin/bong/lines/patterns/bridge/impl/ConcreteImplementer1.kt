package bong.lines.patterns.bridge.impl

import bong.lines.patterns.bridge.inf.Implementer

class ConcreteImplementer1 : Implementer {
    override fun implement() {
        print("전혀 다른 Implementer 1에 대한 프로세스 ")
    }
}
