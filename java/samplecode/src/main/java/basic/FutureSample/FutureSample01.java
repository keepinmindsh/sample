package basic.FutureSample;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureSample01 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        // Submit을 통해서 Thread의 결과를 받을 수 있는 Callback(Callable)을 설정할 수 있다.
        // FutureTask
        // Callable
        Future<String> f = executorService.submit(() -> {
            Thread.sleep(2000);
            System.out.println("Async : " + System.currentTimeMillis() + " Thread : " + Thread.currentThread().getName());
            return "Hello";
        });

        System.out.println(f.isDone());
        System.out.println("Exit : " + System.currentTimeMillis() + " Thread : " + Thread.currentThread().getName());
        Thread.sleep(2100);
        System.out.println(f.isDone());
        // Future의 Get이 호출되는 시점에 Blocking이 발생함
        // Thread에서 등록된 결과를 Hello 값을 반환해오는 시점임
        System.out.println(f.get());



    }
}
