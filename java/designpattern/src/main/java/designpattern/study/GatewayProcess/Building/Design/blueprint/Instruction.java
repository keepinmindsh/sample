package designpattern.study.GatewayProcess.Building.Design.blueprint;

import designpattern.study.GatewayProcess.Building.BuildingFunction.Builder.Building;

public interface Instruction {

    public boolean isValidAmountMineral(int mineral);

    public boolean isValidCapacityPylon(int pylon);

    public Building getBuilder();
}
