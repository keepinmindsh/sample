package designpattern.gof_factoryMethod.sample001.application;

import designpattern.gof_factoryMethod.sample001.Soldier;

public class Client {

    public static void main(String[] args) {
        Soldier marine1 = TraningCenter.createUnitOrNull("MarineBasicUprade");

        marine1.attack();

        marine1.getBattleTraining();
        marine1.getEnhancePower();
    }
}
