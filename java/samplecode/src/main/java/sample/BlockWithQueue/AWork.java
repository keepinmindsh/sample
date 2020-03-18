package sample.BlockWithQueue;

public class AWork implements Work {
    @Override
    public void doWork() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
