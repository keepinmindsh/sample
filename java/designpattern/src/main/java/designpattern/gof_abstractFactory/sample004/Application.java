package designpattern.gof_abstractFactory.sample004;

public class Application {

    public static void main(String[] args) {

        GUIFactory winFactory = GUIProvider.create("WIN");

        Button winButton = winFactory.createButton();

        winButton.paint();
    }
}
