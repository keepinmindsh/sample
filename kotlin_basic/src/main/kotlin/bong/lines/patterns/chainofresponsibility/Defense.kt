package bong.lines.patterns.chainofresponsibility

abstract class Defense{

    lateinit var defense: Defense;

    fun setDefense(defense: Defense) : Defense{
        this.defense = defense

        return defense;
    }


    fun attackByUnit(unit: Unit){
        println("$unit ------------------- Battle Start -------------------")
        println()
        if(defense(unit)){

        }else if(defense)

    }

    abstract fun defense(unit: Unit): Boolean
    abstract fun tryToDefense(unit: Unit): Boolean
    abstract fun getBuildingName(): String
}