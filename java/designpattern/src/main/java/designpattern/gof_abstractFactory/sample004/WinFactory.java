package designpattern.gof_abstractFactory.sample004;

public class WinFactory implements GUIFactory {
    public Button createButton() {
        return new WinButton();
    }
}
