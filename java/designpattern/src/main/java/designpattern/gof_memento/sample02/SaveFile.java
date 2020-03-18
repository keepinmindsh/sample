package designpattern.gof_memento.sample02;

public class SaveFile {

    public String storage;

    public Storage getGameSave(){
        return new Storage(storage);
    }

    public void saveStorage(String gameStorage){
        this.storage = gameStorage;
    }

    public void saveTempStorage(String tempStorage){
        this.storage = tempStorage;
    }
}
