package lines.compare;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.concurrent.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
public class ListenableFutureSample {

    static Callable task = () -> {
        try{
            TimeUnit.SECONDS.sleep(10);
        }catch (Exception exception){
            log.error(exception.getMessage());
            Thread.currentThread().interrupt();
        }
        return null;
    };

    static Runnable runnable = () ->{
        try {
            log.info("runnable은 listenablefuture 실행 후에 동작하는 프로세이다.");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException interruptedException) {
            log.error(interruptedException.getMessage());
            interruptedException.printStackTrace();
        }
    };


    public static void listenableFutureTask() throws Exception {
        ListenableFutureTask listenableFutureTask = new ListenableFutureTask(task);

        listenableFutureTask.addCallback(new ListenableFutureCallback() {
            @Override
            public void onFailure(Throwable ex) {
                log.error(ex.getMessage());
            }

            @Override
            public void onSuccess(Object result) {
                ListenableFutureTask listenableFuture = new ListenableFutureTask(task);
                listenableFuture.addCallback(new ListenableFutureCallback() {
                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println("exception occurred!!");
                    }

                    @Override
                    public void onSuccess(Object o) {
                        System.out.println("all tasks completed!!");
                    }
                });
                listenableFuture.run();

                log.info("listenableFuture run 바로 이후 1");
            }
        });

        // 해당 스레드는 ListenableFutureTask 가 run 되기 전이기 때문에 2 초 동안의 스레드 Sleep이 일어나고
        // 이후 종료되면 20초간의 Listenable의 run은 아래 라인의 run()에서 실행될때 일어난다
        // TODO 그렇다면 이는 메인 스레드에 운영되는 서비스이기 때문에 이와같이 동작하는가? listenablefuture의 효용은 무엇인가?
        // TODO https://knight76.tistory.com/entry/Guava-Futures-%EC%98%88%EC%A0%9C

        runnable.run();

        /**
         * run이 실행되는 시점에 Blocking
         */
        listenableFutureTask.run();

        log.info("listenableFuture run 바로 이후 2");

        try {
            TimeUnit.SECONDS.sleep(15);
        }catch (InterruptedException interruptedException){
            log.error(interruptedException.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws Exception {
        listenableFutureTask();
    }

    /**
     * OutPut
     *
     * > Task :completablefuture:ListenableFuture.main()
     * all tasks completed!!
     * 06:46:40.897 [main] INFO lines.compare.ListenableFuture - listenableFuture run 바로 이후 1
     * 06:46:40.900 [main] INFO lines.compare.ListenableFuture - listenableFuture run 바로 이후 2
     */
}
