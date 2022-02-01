package bong.lines.patterns.chainofresponsibility

class GroundUnit(val unitName:String) : Unit {
    override fun attack() {
        println("지상 유닛이 공격합니다.")
    }

    override fun toString():String {
        return "Hello World - $unitName"
    }
}

class AirUnit(val unitName:String) : Unit {
    override fun attack() {
        println("공중 유닛이 공격합니다.")
    }

    override fun toString(): String {
        return "Hello World - $unitName"
    }
}