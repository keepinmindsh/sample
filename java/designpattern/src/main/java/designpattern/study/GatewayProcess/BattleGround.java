package designpattern.study.GatewayProcess;

import designpattern.study.GatewayProcess.Building.BuildingFunction.Builder.Building;
import designpattern.study.GatewayProcess.Prove.Prove;
import designpattern.study.GatewayProcess.Resources.Mineral;
import designpattern.study.GatewayProcess.Unit.Trainer.Unit;

public class BattleGround {

    public static Mineral mineral;

    public static void main(String[] args) {

        mineral = new Mineral(10000);

        Prove prove = new Prove(150, 1);

        Building gateWay = prove.createBuildingOrNull("GateWay", mineral); // GateWay

        if (gateWay != null) {
            Unit zealot = gateWay.createUnit("질럿", 100, 2, mineral);

            zealot.attack();

            zealot.destroy();
        }
    }
}
