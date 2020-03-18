package designpattern.gof_adapter.sample02;

public class EmergencySituation {
    public static void main(String[] args) {
        CarDriver driver = new DriverChanger(new KoreanAirDriver());

        driver.Driving();
    }
}
