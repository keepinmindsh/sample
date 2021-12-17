package bong.lines.patterns.abstractfactory

import bong.lines.patterns.abstractfactory.building.Barrack
import bong.lines.patterns.abstractfactory.code.UnitType
import bong.lines.patterns.abstractfactory.unit.inf.Unit

fun main() {
    var marine: Unit = Barrack().create(UnitType.MARINE)

    marine.checkStatus()

    println()

    var medic: Unit = Barrack().create(UnitType.MEDIC)

    medic.checkStatus()
}