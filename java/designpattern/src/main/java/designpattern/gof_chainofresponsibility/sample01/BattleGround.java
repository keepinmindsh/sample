package designpattern.gof_chainofresponsibility.sample01;

import designpattern.gof_chainofresponsibility.sample01.Teran.Bunker;
import designpattern.gof_chainofresponsibility.sample01.Teran.Defense;
import designpattern.gof_chainofresponsibility.sample01.Teran.MissileTurret;
import designpattern.gof_chainofresponsibility.sample01.Teran.MissileTurret2;
import designpattern.gof_chainofresponsibility.sample01.Unit.AirUnit;
import designpattern.gof_chainofresponsibility.sample01.Unit.GroundUnit;
import designpattern.gof_chainofresponsibility.sample01.Unit.Unit;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BattleGround {

    public static void main(String[] args) {
        Defense defenseBunker = new Bunker("Bunker");
        Defense defenseMissileTurret = new MissileTurret("Missile Turret1");
        Defense defenseMissileCase = new MissileTurret2("Missile Turret2");

        defenseBunker.setDifense(defenseMissileTurret);
        defenseBunker.setDifense(defenseMissileCase);
        defenseBunker.setDifense(defenseBunker);

        List<Unit> unitList = Arrays.asList(new AirUnit("커세어"), new GroundUnit("마린"), new AirUnit("배틀쉽"));

        Stream<Unit> streamUnit = unitList.stream();

        streamUnit.forEach(unit -> {
            defenseBunker.attackCommand(unit);
        });

    }
}
