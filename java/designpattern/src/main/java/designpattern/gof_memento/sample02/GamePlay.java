package designpattern.gof_memento.sample02;

public class GamePlay {

    public static void main(String[] args) {
        Game game = new Game();
        SaveFile storage = new SaveFile();

        storage.saveTempStorage("임시저장 1");
        
        storage.saveTempStorage("임시저장 2");

        game.addSaveList(storage.getGameSave());

        storage.saveTempStorage("임시저장 3");

        storage.saveTempStorage("임시저장 4");

        game.addSaveList(storage.getGameSave());

        storage.saveTempStorage("임시저장 5");
        storage.saveTempStorage("임시저장 6");

        System.out.println(game.loadSaveData(0).getStorage());
        System.out.println(game.loadSaveData(1).getStorage());


    }
}
