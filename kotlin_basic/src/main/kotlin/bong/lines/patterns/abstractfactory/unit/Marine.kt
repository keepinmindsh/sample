package bong.lines.patterns.abstractfactory.unit

import bong.lines.patterns.abstractfactory.unit.inf.Unit

class Marine : Unit {
    override fun checkStatus() {
        print("Marine Status is Good!")
    }
}