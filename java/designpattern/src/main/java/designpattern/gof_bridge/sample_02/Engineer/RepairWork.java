package designpattern.gof_bridge.sample_02.Engineer;

import designpattern.gof_bridge.sample_02.Cars.Menufacture;

public class RepairWork extends EngineerWork {

    public RepairWork(Menufacture menufacture) {
        super(menufacture);
    }

    @Override
    public void doWork(Thread thread) {
        try {
            doRepair(thread);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void doRepair(Thread thread) throws InterruptedException {
        System.out.println("차량을 수리합니다.");

        for (int i = 1; i <= 5; i++) {
            thread.sleep(1000);
            System.out.println(1 + "초");
        }
    }


}
