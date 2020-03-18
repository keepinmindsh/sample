package designpattern.gof_adapter.sample02;

public class DriverChanger implements CarDriver {

    private AirplanDriver driver;

    public DriverChanger(AirplanDriver airplanDriver) {
        this.driver = airplanDriver;

    }

    public void Driving() {
        driver.Flying();
    }
}
