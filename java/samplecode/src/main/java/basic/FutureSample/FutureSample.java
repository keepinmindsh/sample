package basic.FutureSample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class FutureSample {

    //private static Logger logger = LoggerFactory.getLogger(FutureSample.class);

    public static void main(String[] args) throws InterruptedException {
        // Thread Pool 생성
        ExecutorService executorService = Executors.newCachedThreadPool();


        executorService.execute(() ->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //logger.info("Async");
            System.out.println("Async : " + System.currentTimeMillis() + " Thread : " + Thread.currentThread().getName());
        });


        //logger.info("Exit");
        System.out.println("Exit : " + System.currentTimeMillis()+ " Thread : " + Thread.currentThread().getName());

    }
}
