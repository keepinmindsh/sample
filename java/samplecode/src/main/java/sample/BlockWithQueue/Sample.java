package sample.BlockWithQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sample {

    private static final ExecutorService executorService1 = Executors.newFixedThreadPool(100);
    private static final ExecutorService executorService2 = Executors.newFixedThreadPool(100);

    public static void main(String[] args) {


        for (int i = 0; i < 1; i++) {
            executorService1.execute(() -> { excuteWork(new AWork(), "WINGSPMS51111");});
            executorService1.execute(() -> { excuteWork(new BWork(), "WINGSPMS11111");});
            executorService1.execute(() -> { excuteWork(new CWork(), "WINGSPMS31111");});
            executorService1.execute(() -> { excuteWork(new DWork(), "WINGSPMS71111");});
            executorService1.execute(() -> { excuteWork(new AWork(), "WINGSPMS51111");});
            executorService1.execute(() -> { excuteWork(new AWork(), "WINGSPMS51111");});

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private static void excuteWork(Work work, String companyId) {
        if(LockingQueue.checkIfabsent(companyId)){

            System.out.println(Thread.currentThread().getName() + "데이터가 추가되었습니다 " + companyId);

            LockingQueue.insertToQueue(companyId);

            System.out.println(Thread.currentThread().getName() +"작업 중입니다.");
            work.doWork();

            System.out.println(Thread.currentThread().getName() + "작업이 완료되었습니다. ");

            LockingQueue.removeQueue(companyId);

            System.out.println(Thread.currentThread().getName() + "데이터가 삭제되었습니다. " + companyId);

        }else{

            System.out.println(Thread.currentThread().getName() +"작업중이어서 처리할 수 없습니다.");

        }
    }

}
