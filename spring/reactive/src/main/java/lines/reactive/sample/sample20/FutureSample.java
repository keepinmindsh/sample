package lines.reactive.sample.sample20;

import java.util.concurrent.*;

public class FutureSample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        FutureTask<String> futureTask = new FutureTask<String>( () -> {
            Thread.sleep(2000);
            System.out.println("Future Task!");

            return "Hello : Future Task";
        });

        executorService.execute(futureTask);

        try {
            System.out.println(futureTask.get());

            System.out.println("Exit");
        } catch(Exception e) {
            e.printStackTrace();
        }

        // Callback 기법을 활용할 수 있는 메커니즘이 존재함.
        FutureTask<String> futureTaskOverride = new FutureTask<String>( () -> {
            Thread.sleep(2000);
            System.out.println("Future Task!");

            return "Hello : Future Task";
        }){
            @Override
            protected void done() {
                try {
                    System.out.println(get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        };

        executorService.execute(futureTaskOverride);

        try {
            System.out.println(futureTaskOverride.get());

            System.out.println("Exit");
        } catch(Exception e) {
            e.printStackTrace();
        }


        Future future = executorService.submit(() -> {
            Thread.sleep(2000);
            System.out.println("Future!");
            return "Hello : Future";
        });

        try {
            // 미래에 실행된 값을 가져오는 get 함수
            // Producer/Consumer 패턴에서 사용 가능함
            // Future를 활용한 실 사용 사례 확인
            // Future 와 Callback
            System.out.println(future.get());

            System.out.println("Exit");
        } catch(Exception e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
