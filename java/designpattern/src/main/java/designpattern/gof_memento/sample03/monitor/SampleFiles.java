package designpattern.gof_memento.sample03.monitor;

import designpattern.gof_memento.sample03.gamesave.SaveFiles;
import designpattern.gof_memento.sample03.units.Marine;
import designpattern.gof_memento.sample03.units.Unit;
import designpattern.gof_memento.sample03.units.Zealot;

import java.util.Arrays;
import java.util.List;

public class SampleFiles {
    public static void main(String[] args) throws Exception {
        Unit marine1 = new Marine.Builder(40)
                .setAttackGuage(6)
                .setMarineName("마린 1")
                .setShield(0).build();


        Unit zealot1 = new Zealot.Builder(100)
                .setAttackGuage(16)
                .setZealotName("질럿 1")
                .setShield(60).build();

        SaveFiles saveFiles = new SaveFiles();

        saveFiles.setSavePoint(Arrays.asList(marine1));

        marine1.damaged(zealot1.attack());

        Arrays.asList(marine1).stream().forEach(
            unit -> {
                unit.checkHealthStatus();
            }
        );

        saveFiles.setSavePoint(Arrays.asList(marine1));


        List<Unit> list = saveFiles.getUnitFromSavePoint(0);

        for(Unit unit : list){
            if(unit instanceof Marine){
                marine1 = unit;
            }
        }

        Arrays.asList(marine1).stream().forEach(
                unit -> {
                    unit.checkHealthStatus();
                }
        );

        List<Unit> list2 = saveFiles.getUnitFromSavePoint(1);

        for(Unit unit : list2){
            if(unit instanceof Marine){
                marine1 = unit;
            }
        }

        Arrays.asList(marine1).stream().forEach(
                unit -> {
                    unit.checkHealthStatus();
                }
        );

    }
}
