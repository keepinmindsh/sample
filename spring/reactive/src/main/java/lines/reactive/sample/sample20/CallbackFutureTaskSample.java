package lines.reactive.sample.sample20;

import java.util.concurrent.*;

import static java.util.Objects.requireNonNull;

public class CallbackFutureTaskSample {

    interface SucessCallback {
        void onSuccess(String result);
    }
    interface ExceptionCallback {
        void onError(Throwable t);
    }

    public static class CallbackFutureTask extends FutureTask<String> {
        SucessCallback sc;
        ExceptionCallback ec;
        public CallbackFutureTask(Callable<String> callable, SucessCallback sc, ExceptionCallback ec){
            super(callable);
            this.sc = requireNonNull(sc);
            this.ec = requireNonNull(ec);

        }

        @Override
        protected void done() {
            try {
                sc.onSuccess(get());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                ec.onError(e.getCause());
            }
        }
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        CallbackFutureTask f = new CallbackFutureTask(() -> {

            Thread.sleep(2000);
            //if( 1 == 1) throw new RuntimeException("Error!");
            // Error Callback읇 받을 수 잇게 처리하는 방법
            System.out.println("Hello");
            return "Hello";
        }
        , result -> System.out.println("Result : " + result)
        , error -> System.out.println("Error : " + error.getMessage()));

        executorService.execute(f);

        executorService.shutdown();
    }
}
