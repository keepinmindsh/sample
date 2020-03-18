package sample.BlockWithQueue;

public class DWork implements Work {
    @Override
    public void doWork() {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
