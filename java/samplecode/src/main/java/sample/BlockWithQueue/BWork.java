package sample.BlockWithQueue;

public class BWork implements Work {
    @Override
    public void doWork() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
