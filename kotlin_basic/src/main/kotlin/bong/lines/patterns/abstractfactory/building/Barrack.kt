package bong.lines.patterns.abstractfactory.building

import bong.lines.patterns.abstractfactory.code.UnitType
import bong.lines.patterns.abstractfactory.unit.Marine
import bong.lines.patterns.abstractfactory.unit.Medic
import bong.lines.patterns.abstractfactory.unit.inf.Unit

class Barrack {
    fun create(unitType: UnitType) : Unit {
        return when(unitType){
            UnitType.MARINE -> Marine()
            UnitType.MEDIC -> Medic()
        }
    }
}