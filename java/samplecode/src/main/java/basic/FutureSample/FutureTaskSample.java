package basic.FutureSample;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskSample {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        FutureTask<String> f = new FutureTask<String>(() ->{
           Thread.sleep(2000);
            System.out.println("Async : " + System.currentTimeMillis() + " Thread : " + Thread.currentThread().getName());
            return "Hello";
        }) {
            @Override
            protected void done(){
                try {
                    System.out.println(get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        };

        // 어떤 비동기 작업을 실행하라고 하는 기본 함수 : execute
        executorService.execute(f);
        executorService.shutdown();
    }
}
