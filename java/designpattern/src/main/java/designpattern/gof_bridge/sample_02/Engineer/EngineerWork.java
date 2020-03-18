package designpattern.gof_bridge.sample_02.Engineer;

import designpattern.gof_bridge.sample_02.Cars.Menufacture;

public abstract class EngineerWork {

    public Menufacture menufacture;

    public EngineerWork(Menufacture menufacture) {
        this.menufacture = menufacture;
    }

    public abstract void doWork(Thread thread);

}
