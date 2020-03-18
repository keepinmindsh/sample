package designpattern.gof_memento.sample03.gamesave;

import designpattern.gof_memento.sample03.units.Unit;

import java.util.List;

public class SavePoint {

    private List<Unit> unitList;

    public SavePoint(List<Unit> unitList){
        this.unitList = unitList;
    }

    public List<Unit> getUnitFromSavePoint(){
        return unitList;
    }
}
