package basic.FutureSample;

import java.util.Objects;
import java.util.concurrent.*;

public class FutureTaskCallback {

    interface SuccessCallback {
        void onSucces(String result);
    }

    interface ExceptionCallback {
        void onError(Throwable t);
    }

    public static class CallbackFutureTask extends FutureTask<String> {
        SuccessCallback successCallback;
        ExceptionCallback exceptionCallback;

        public CallbackFutureTask(Callable<String> callable, SuccessCallback sc, ExceptionCallback ec) {
            super(callable);
            // 인자의 null 체크를 해주고 null이 아닐 시 그대로 반환, null일 경우 NPE를 발생시킨다.
            this.successCallback = Objects.requireNonNull(sc);
            this.exceptionCallback = Objects.requireNonNull(ec);
        }

        @Override
        protected void done() {
            try {
                successCallback.onSucces(get());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                exceptionCallback.onError(e.getCause());
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        CallbackFutureTask f = new CallbackFutureTask(() -> {
            Thread.sleep(2000);
            if( 1 == 1) throw new RuntimeException("Async Error!");
            System.out.println("Async : " + System.currentTimeMillis() + " Thread : " + Thread.currentThread().getName());
            return "Hello";
        },
                System.out::println
                , e -> System.out.println("Error : " + e.getMessage()));

        executorService.execute(f);
        executorService.shutdown();
    }

}
