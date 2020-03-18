package designpattern.gof_factoryMethod.sample001.application;

import designpattern.gof_factoryMethod.sample001.Barrack;
import designpattern.gof_factoryMethod.sample001.Marine;
import designpattern.gof_factoryMethod.sample001.Soldier;
import designpattern.gof_factoryMethod.sample001.SoldierUnitCreator;

public class TraningCenter {

    public static Soldier createUnitOrNull(String UnitType) {

        switch (UnitType) {
            case "MarineBasicUprade":
                SoldierUnitCreator barrack = new Barrack();

                Soldier marine1 = new Marine();

                return barrack.createUnit(marine1);
            default:
                return null;

        }
    }
}
