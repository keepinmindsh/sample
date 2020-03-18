package designpattern.gof_abstractFactory.sample004;

public class OSXFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new OSXButton();
    }
}
