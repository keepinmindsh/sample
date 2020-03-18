package sample.BlockWithQueue;

public class CWork implements Work {
    @Override
    public void doWork() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
