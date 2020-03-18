package designpattern.study.GatewayProcess.Prove;

import designpattern.study.GatewayProcess.Building.BuildingDesign;
import designpattern.study.GatewayProcess.Building.BuildingFunction.Builder.Building;
import designpattern.study.GatewayProcess.Building.Design.blueprint.Design;
import designpattern.study.GatewayProcess.Building.Design.blueprint.Instruction;
import designpattern.study.GatewayProcess.Resources.Mineral;

public class Prove {

    private final int mineral;
    private final int pylon;

    public Prove(int mineral, int pylon) {
        this.mineral = mineral;
        this.pylon = pylon;
    }

    public Building createBuildingOrNull(String Type, Mineral mineralCalc) {

        Design design = BuildingDesign.getDesignForProveOrNull(Type);

        if (design == null) {
            System.out.println("프로브가 건설할 수 있는 건물이 아닙니다.");

            return null;
        }

        Instruction instruction = design.blueprint();

        if (!instruction.isValidAmountMineral(mineral)) {
            System.out.println("Mineral이 부족합니다.");

            return null;
        }

        if (!instruction.isValidCapacityPylon(pylon)) {
            System.out.println("Pylon이 부족합니다.");

            return null;
        }

        mineralCalc.useMineral(mineral);

        return instruction.getBuilder();
    }
}
