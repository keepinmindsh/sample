package sample.Reactive.callrestapi;



import sample.Reactive.callrestapi.publisher.CallRestSubscriber;
import sample.Reactive.callrestapi.publisher.RequestPublisher;
import sample.Reactive.callrestapi.queuemanager.QueueManager;

import java.util.HashMap;
import java.util.concurrent.*;

public class RequestWithReactive {

    private static BlockingQueue<HashMap<String, Object>> queue;

    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) throws Exception {

        scheduler();

        while (true){

            /*

            select 로직

            update 로직

             */

            queue = new ArrayBlockingQueue<>(50);

            for (int i = 0; i < 20 ; i++) {
                HashMap<String, Object> paramMap = new HashMap<>();

                paramMap.put("key", i);
                paramMap.put("company_key", i * i);

                queue.add(paramMap);
            }

            QueueManager.addQueue("WINGSPMS", queue);

            System.out.println("Add Queue !!");

            Thread.sleep(10000);
        }
    }

    public static void scheduler(){
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {

                System.out.println("Call Service !!");

                RequestPublisher requestPublisher = new RequestPublisher(QueueManager::getQueue, "WINGSPMS");

                requestPublisher.subscribe(new CallRestSubscriber(10));
            }
        }, 1000L, 5000L,  TimeUnit.MILLISECONDS);
    }

}
