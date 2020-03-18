package designpattern.gof_templateMethod.sample01;

import designpattern.gof_templateMethod.sample01.Unit.Unit;
import designpattern.gof_templateMethod.sample01.building.Barrack;
import designpattern.gof_templateMethod.sample01.building.UnitBuilding;

import java.util.Arrays;
import java.util.List;

public class BattleGround {
    public static void main(String[] args) throws InterruptedException {

        List<String> unitList = Arrays.asList("Marine", "Medic", "FireBat", "Marine" );

        UnitBuilding barrack = new Barrack();

        List<Unit> units = barrack.readyToBattle(unitList);

        units.forEach( unit -> unit.unitName() );
    }
}
