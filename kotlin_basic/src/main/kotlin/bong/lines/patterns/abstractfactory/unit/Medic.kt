package bong.lines.patterns.abstractfactory.unit

import bong.lines.patterns.abstractfactory.unit.inf.Unit

class Medic : Unit {
    override fun checkStatus() {
        print("Medic Status is good")
    }
}