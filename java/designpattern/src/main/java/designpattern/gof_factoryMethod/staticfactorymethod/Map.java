package designpattern.gof_factoryMethod.staticfactorymethod;

public class Map {

    private int xPosistion;
    private int yPosistion;

    public void moveObjectToPosition(int xPosition, int yPosition) {
        this.xPosistion = xPosition;
        this.yPosistion = yPosition;
    }
}
