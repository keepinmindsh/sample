package designpattern.gof_memento.sample02;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static List<Storage> listSave = new ArrayList<>();

    public void addSaveList(Storage storage){
        listSave.add(storage);
    }

    public Storage loadSaveData(int savePoint){
        return listSave.get(savePoint);
    }
}
