package designpattern.study.GatewayProcess.Building.BuildingFunction.Builder;

import designpattern.study.GatewayProcess.Resources.Mineral;
import designpattern.study.GatewayProcess.Unit.Trainer.Unit;

public interface Building {

    public Unit createUnit(String unitName, int mineral, int pylon, Mineral mineralCalc);
}
