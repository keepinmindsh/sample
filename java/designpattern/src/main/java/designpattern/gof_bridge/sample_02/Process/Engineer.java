package designpattern.gof_bridge.sample_02.Process;

import designpattern.gof_bridge.sample_02.WorkShop;

public class Engineer extends Thread {
    public void run(String Type, String CarType) {
        WorkShop.MenuFacture(this, Type, CarType);
    }
}
