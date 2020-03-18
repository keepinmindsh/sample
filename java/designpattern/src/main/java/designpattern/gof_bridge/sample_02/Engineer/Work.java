package designpattern.gof_bridge.sample_02.Engineer;

import designpattern.gof_bridge.sample_02.Cars.Menufacture;

public class Work extends EngineerWork {

    public Work(Menufacture menufacture) {
        super(menufacture);
    }

    @Override
    public void doWork(Thread thread) {
        try {
            doProduce(thread);

            doAssemble(thread);

            doTest(thread);

            doPaint(thread);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doProduce(Thread thread) throws InterruptedException {

        System.out.println("재료를 생산합니다.");

        for (int i = 1; i <= 5; i++) {
            thread.sleep(1000);
            System.out.println(i + "초");
        }
    }

    public void doAssemble(Thread thread) throws InterruptedException {

        System.out.println("재료를 조립합니다.");

        for (int i = 1; i <= 5; i++) {
            thread.sleep(1000);
            System.out.println(i + "초");
        }
    }

    public void doTest(Thread thread) throws InterruptedException {

        System.out.println("검증 합니다.");

        for (int i = 1; i <= 10; i++) {
            thread.sleep(1000);
            System.out.println(i + "초");
        }
    }

    public void doPaint(Thread thread) throws InterruptedException {

        System.out.println("도색 합니다.");

        for (int i = 1; i <= 2; i++) {
            thread.sleep(1000);
            System.out.println(i + "초");
        }
    }
}
