package designpattern.gof_memento.sample03.monitor;

import designpattern.gof_memento.sample03.gamesave.SaveFiles;
import designpattern.gof_memento.sample03.units.Marine;
import designpattern.gof_memento.sample03.units.Unit;
import designpattern.gof_memento.sample03.units.Zealot;
import designpattern.gof_memento.sample03.units.Zergling;

import java.util.Arrays;
import java.util.List;

public class GamePlay {
    public static void main(String[] args) throws Exception {
         Unit marine1 = new Marine.Builder(40)
                     .setAttackGuage(6)
                     .setMarineName("마린 1")
                     .setShield(0).build();


        Unit zealot1 = new Zealot.Builder(100)
                .setAttackGuage(16)
                .setZealotName("질럿 1")
                .setShield(60).build();


        Unit zergling1 = new Zergling.Builder(35)
                .setAttackGuage(5)
                .setZerglingName("저글링 1")
                .setShield(0).build();

        SaveFiles saveFiles = new SaveFiles();

        saveFiles.setSavePoint(Arrays.asList(marine1, zealot1, zergling1));

        marine1.damaged(zealot1.attack());
        zealot1.damaged(zergling1.attack());
        zealot1.damaged(marine1.attack());
        zealot1.damaged(marine1.attack());
        zealot1.damaged(marine1.attack());
        zealot1.damaged(marine1.attack());
        zealot1.damaged(marine1.attack());
        zealot1.damaged(marine1.attack());
        zealot1.damaged(marine1.attack());
        zealot1.damaged(marine1.attack());
        zealot1.damaged(marine1.attack());
        zealot1.damaged(marine1.attack());
        zealot1.damaged(marine1.attack());
        zealot1.damaged(marine1.attack());
        zealot1.damaged(marine1.attack());
        zealot1.damaged(marine1.attack());
        zealot1.damaged(marine1.attack());


        Arrays.asList(marine1, zealot1, zergling1).stream().forEach(
            unit -> {
                unit.checkHealthStatus();
            }
        );

        saveFiles.setSavePoint(Arrays.asList(marine1, zealot1, zergling1));

        marine1.damaged(zealot1.attack());
        zealot1.damaged(zergling1.attack());
        zealot1.damaged(marine1.attack());

        Arrays.asList(marine1, zealot1, zergling1).stream().forEach(
                unit -> {
                    unit.checkHealthStatus();
                }
        );

        List<Unit> list = saveFiles.getUnitFromSavePoint(0);

        for(Unit unit : list){
            if(unit instanceof Marine){
                marine1 = unit;
            }else if(unit instanceof Zealot){
                zealot1 = unit;
            }else{
                zergling1 = unit;
            }
        }

        Arrays.asList(marine1, zealot1, zergling1).stream().forEach(
            unit -> {
                unit.checkHealthStatus();
            }
        );
    }

}
