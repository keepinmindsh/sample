package designpattern.study.StracraftSample.Controller;

import designpattern.study.StracraftSample.Buildings.Building;
import designpattern.study.StracraftSample.Property.Positions.ObjectProperty;
import designpattern.study.StracraftSample.Property.Positions.Position;
import designpattern.study.StracraftSample.Property.Resources.Resource;
import designpattern.study.StracraftSample.Units.Unit;

import java.util.ArrayList;
import java.util.List;

public class Map {
    public ObjectProperty mapSize;
    private static List<Unit> unitList = new ArrayList<>();
    private static List<Building> buildingList = new ArrayList<>();
    private static List<Resource> mienralList = new ArrayList<>();
    private static List<Resource> gasList = new ArrayList<>();

    /**
     * @param mapSize
     */
    public Map(ObjectProperty mapSize) {
        this.mapSize = mapSize;
    }

    /**
     * @param unit
     */
    public void addUnit(Unit unit) {
        synchronized (unitList) {
            unitList.add(unit);
        }
    }

    /**
     * @param building
     */
    public void addBuilding(Building building) {
        synchronized (buildingList) {
            buildingList.add(building);
        }
    }

    /**
     * @param mineral
     */
    public void addMienral(Resource mineral) {
        synchronized (mienralList) {
            mienralList.add(mineral);
        }
    }

    /**
     * @param gas
     */
    public void addGas(Resource gas) {
        synchronized (gasList) {
            gasList.add(gas);
        }
    }

    /**
     * @param unit
     */
    public void removeUnit(Unit unit) {
        synchronized (unitList) {
            unitList.remove(unit);
        }
    }

    /**
     * @param building
     */
    public void removeBuilding(Building building) {
        synchronized (buildingList) {
            buildingList.remove(building);
        }
    }

    /**
     * @param mineral
     */
    public void removeMineral(Resource mineral) {
        synchronized (mienralList) {
            mienralList.remove(mineral);
        }
    }

    /**
     * @param gas
     */
    public void removeGas(Resource gas) {
        synchronized (gasList) {
            gasList.remove(gas);
        }
    }

    /**
     * @return
     */
    public boolean checkUnitPosition(ObjectProperty position) {

        Position pos = (Position) position.getProperty();

        pos.getPositionX();
        pos.getPositionY();

        return true;
    }
}
