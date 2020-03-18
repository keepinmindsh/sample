package designpattern.study.GatewayProcess.Building.Design;

import designpattern.study.GatewayProcess.Building.BuildingFunction.Builder.Building;
import designpattern.study.GatewayProcess.Building.Design.blueprint.Instruction;
import designpattern.study.GatewayProcess.Meterial.Meterial;

public class WayToMakeBuilding implements Instruction {

    private final Meterial meterial;
    private final Building building;

    public WayToMakeBuilding(Meterial meterial, Building building) {
        this.meterial = meterial;
        this.building = building;
    }

    /**
     * Mineral 양을 체크한다.
     *
     * @param mineral
     * @return
     */
    public boolean isValidAmountMineral(int mineral) {
        if (meterial.getMineralAmount() != mineral) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Pylon 갯수를 체크한다.
     *
     * @param pylonCapacity
     * @return
     */
    public boolean isValidCapacityPylon(int pylonCapacity) {
        if (meterial.getPylonCapacity() != pylonCapacity) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 빌딩 객체를 반환한다.
     *
     * @return
     */
    public Building getBuilder() {
        return this.building;
    }
}
