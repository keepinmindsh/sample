package designpattern.study.StracraftSample.Property.Positions;

public class Position implements ObjectProperty {

    private int positionX;
    private int positionY;

    public Position(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public ObjectProperty getProperty() {
        return this;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
}
