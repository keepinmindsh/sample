package designpattern.gof_bridge.sample_02;

import designpattern.gof_bridge.sample_02.Cars.BikeMenufacture;
import designpattern.gof_bridge.sample_02.Cars.BusMenufacture;
import designpattern.gof_bridge.sample_02.Cars.CarMenufacture;
import designpattern.gof_bridge.sample_02.Cars.Menufacture;
import designpattern.gof_bridge.sample_02.Engineer.EngineerWork;
import designpattern.gof_bridge.sample_02.Engineer.RepairWork;
import designpattern.gof_bridge.sample_02.Engineer.Work;

public class WorkShop {

    public static void MenuFacture(Thread thread, String Type, String CarType) {

        Menufacture menufacture;

        // 자동차 종류
        switch (CarType) {
            case "Bike":
                menufacture = new BikeMenufacture();
                break;
            case "Bus":
                menufacture = new BusMenufacture();
                break;
            case "Car":
                menufacture = new CarMenufacture();
                break;
            default:
                menufacture = null;
        }

        EngineerWork engineer;

        // 요청 구분
        switch (Type) {
            case "create":

                engineer = new Work(menufacture);

                break;
            case "repair":

                engineer = new RepairWork(menufacture);

                break;
            default:
                engineer = null;
                break;
        }

        if (engineer != null) {
            engineer.doWork(thread);
        } else {
            System.out.println("해당 요구 사항은 처리 불가능 합니다. ");
        }
    }
}
