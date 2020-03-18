package designpattern.gof_memento.sample03.gamesave;

import designpattern.gof_memento.sample03.units.Marine;
import designpattern.gof_memento.sample03.units.Unit;

import java.util.ArrayList;
import java.util.List;

public class SaveFiles {

    private final List<SavePoint> savePointList = new ArrayList<>();

    public void setSavePoint(List<Unit> unitList){
        savePointList.add(new SavePoint(createUnitForSave(unitList)));
    }

    public List<Unit> getUnitFromSavePoint(int i) throws Exception {
        if(i > -1 && savePointList.size() > i  ){
            savePointList.get(i).getUnitFromSavePoint().stream().forEach(
                unit -> {
                    unit.checkHealthStatus();
                }
            );

            return savePointList.get(i).getUnitFromSavePoint();
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    private List<Unit> createUnitForSave(List<Unit> unitList){
        List<Unit> returnUnitList = new ArrayList<>();

        unitList.forEach(unit -> {

            Marine.Builder maringBuilder = new Marine.Builder(40)
                    .setAttackGuage(6)
                    .setMarineName("마린 1");

            maringBuilder.setUnitState(unit.getUnitStatus());

            Marine marine = maringBuilder.build();

            returnUnitList.add(marine);
        });

        return returnUnitList;
    }
}
