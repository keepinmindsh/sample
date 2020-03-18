package designpattern.study.GatewayProcess.Building.Design;

import designpattern.study.GatewayProcess.Building.BuildingFunction.Builder.Building;
import designpattern.study.GatewayProcess.Building.BuildingFunction.GateWay;
import designpattern.study.GatewayProcess.Building.Design.blueprint.Design;
import designpattern.study.GatewayProcess.Building.Design.blueprint.Instruction;
import designpattern.study.GatewayProcess.Meterial.Meterial;

public class GatewayBluePrint implements Design {

    public Instruction blueprint() {
        // 재료에 대한 빌더를 생성한다.
        Meterial.Builder meterialBuilder = new Meterial.Builder();

        // 게이트웨이 객체를 생성한다.
        Building building = new GateWay();

        // 재료를 설정한다.
        Meterial meterial = meterialBuilder
                .mineral(150)
                .pylon(1)
                .Build();

        return new WayToMakeBuilding(meterial, building);
    }

}
