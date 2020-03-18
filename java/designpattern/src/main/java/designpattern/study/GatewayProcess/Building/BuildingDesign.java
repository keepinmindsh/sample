package designpattern.study.GatewayProcess.Building;

import designpattern.study.GatewayProcess.Building.Design.GatewayBluePrint;
import designpattern.study.GatewayProcess.Building.Design.blueprint.Design;

public class BuildingDesign {

    public static Design getDesignForProveOrNull(String bluePrint) {
        if ("GateWay".equals(bluePrint)) {
            return new GatewayBluePrint();
        } else {
            return null;
        }
    }
}
