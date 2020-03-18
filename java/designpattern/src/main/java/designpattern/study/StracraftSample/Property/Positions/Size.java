package designpattern.study.StracraftSample.Property.Positions;

public class Size implements ObjectProperty {

    private final int width;
    private final int height;

    public Size(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public ObjectProperty getProperty() {
        return this;
    }
}
