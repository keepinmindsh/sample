package bong.lines.patterns.bridge.impl

import bong.lines.patterns.bridge.inf.Implementer

class ConcreteImplementer2 : Implementer {
    override fun implement() {
        print("전혀 다른 Implementer 2에 대한 프로세스 ")
    }
}
