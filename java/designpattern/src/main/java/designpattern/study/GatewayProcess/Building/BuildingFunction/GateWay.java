package designpattern.study.GatewayProcess.Building.BuildingFunction;

import designpattern.study.GatewayProcess.Building.BuildingFunction.Builder.Building;
import designpattern.study.GatewayProcess.Resources.Mineral;
import designpattern.study.GatewayProcess.Unit.Builder.UnitBuilder;
import designpattern.study.GatewayProcess.Unit.Trainer.Unit;

public class GateWay implements Building {
    public Unit createUnit(String unitName, int mineral, int pylon, Mineral mineralCalc) {

        UnitBuilder.Builder unitBuilder = new UnitBuilder.Builder();

        unitBuilder.mineral(mineral)
                .pylon(pylon);

        mineralCalc.useMineral(mineral);

        return unitBuilder.unitTrainer(unitName);
    }
}
