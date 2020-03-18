package designpattern.gof_abstractFactory.sample004;

public class GUIProvider {

    public static GUIFactory create(String factoryType) {
        switch (factoryType) {
            case "WIN":
                return new WinFactory();
            case "OSX":
                return new OSXFactory();
            default:
                return new WinFactory();
        }
    }
}
