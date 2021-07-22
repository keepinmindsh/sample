package lines.reactivewebflux.ProjectReactorCoreSample;

import lombok.extern.slf4j.Slf4j;
import reactor.core.Disposable;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;

import java.io.IOException;
import java.time.Duration;

@Slf4j
public class HandlingErrors {
    public static void main(String[] args) {

        log.info("Reactor Error Handling ---------  1. Reactive Programming onErrorReturn -- START ------------------  ");
        log.info(" 에러 발생 시점에 다음 아이템으로 진행되지 않고 에러가 발생함. ");

        Flux.just(1, 2, 0, 3, 4, 5)
            .map(item -> "100 / " + item + " = " + ( 100 / item )).log()
            .onErrorReturn("Divded by Zero : (").subscribe(item -> log.info(item), error -> log.error(error.getMessage())) ;

        log.info("  ");
        log.info("Reactor Error Handling ---------  1. Reactive Programming onErrorReturn -- END ------------------  ");

        log.info("Reactor Error Handling ---------  2. Reactive Programming Error -- START ------------------  ");
        log.info(" 에러 발생 시점에 다음 아이템으로 진행되지 않고 에러가 발생함. Reactive Programming 내에 에러가 발생하면 에러 반환 처리 ");

        Flux<String> stringFlux = Flux.range(1, 10)
                .map(v -> doSomethingDangerous(v) )
                .log()
                .map(v -> doSecondTransform(v));

        stringFlux.subscribe(value -> log.info("Received  : {} ", value),
                             error -> log.error("CAUGHT : {} ", error.getMessage())
                );

        log.info("  ");
        log.info("Reactor Error Handling ---------  2. Reactive Programming Error -- END ------------------  ");

        log.info("Reactor Error Handling ---------  3. Reactive Programming onErrorReturn -- START ------------------  ");
        log.info(" onErrorReturn에서 에러가 발생하였을 때 fallback Value를 이용하면, 에러 발생 시점에 반환값으로 에러 상황을 대체할 수 있다.  ");

        Flux.just(10, 5)
                .map(Dangerous::doSomethingDangerous)
                .onErrorReturn("Divided By Zero!").subscribe(item -> log.info("Value 1 : {}", item), error -> log.error(error.getMessage()) );


        Flux.just(10, 5, 20, 40)
                .map(Dangerous::doSomethingDangerous)
                .onErrorReturn(error -> error.getMessage().equals("/ by zero") , "recovered5"  ).subscribe(item -> log.info("Value 2 : {}", item), error -> log.error(error.getMessage()) );


        log.info("  ");
        log.info("Reactor Error Handling ---------  3. Reactive Programming onErrorReturn -- END ------------------  ");

        log.info("Reactor Error Handling ---------  4. Reactive Programming Error Callback -- START ------------------  ");
        log.info("flatMap 내부에서 각각의 Flux 아이템을 실행한다. 에러가 발생하였을 때 Flux 아이템에 값을 넣어서 반환할 수 있다. \r\n " +
                 "flatMap 의 경우 에는 각각 아이템을 평면화하여 실행할 수 있으며, 각각의 아이템 별로 에러를 실행하기 때문에 모든 아이템에 대해서 실행할 수 있다. \r\n" +
                 "onErrorResume 은 에러가 발생 하고 다음 단계를 진행 한다.");

        Flux.just("key1", "key5", "key2", "key3")
                .flatMap(k -> Flux.just(k).map(item -> String.valueOf(CallExternAPI.callAPI(item))).onErrorResume(e -> Flux.just("key1") ) )
                .log()
                .subscribe(item -> log.info("Value 4 : {}", item), error -> log.error(error.getMessage()));

        log.info("  ");
        log.info("Reactor Error Handling ---------  4. Reactive Programming Error Callback -- END ------------------  ");

        log.info("Reactor Error Handling ---------  5. Reactive Programming onErrorResume -- START ------------------  ");
        log.info("에러 발생후 Mono에 에러를 담아 값을 반환한다.  ");

        Flux.just("key1", "key2", "key3", "key3", "key1", "key2")
                .map(item -> String.valueOf(CallExternAPI.callAPI(item))).onErrorResume(e -> Mono.just(MyWrapper.fromError(e)))
                .log()
                .subscribe(item -> log.info("Value 5 : {}", item), error -> log.error(error.getMessage()));

        log.info("  ");
        log.info("Reactor Error Handling ---------  5. Reactive Programming onErrorResume -- END ------------------  ");

        log.info("Reactor Error Handling ---------  6. Reactive Programming onErrorResume -- START ------------------  ");
        log.info(" Flux에 error를 담아 값을 반환 처리  ");

        Flux.just("timeout1", "timeout2", "timeout3", "timeout4")
                .flatMap(k -> Flux.just(String.valueOf(CallExternAPI.callAPI(String.valueOf(k)))))
                .onErrorResume(error -> Flux.error(new Exception("Value 6 Error!!")))
                .log()
                .subscribe(item -> log.info("Value 6 : {}", item), error -> log.error(error.getMessage()));

        log.info("  ");
        log.info("Reactor Error Handling ---------  6. Reactive Programming onErrorResume -- END ------------------  ");

        log.info("Reactor Error Handling ---------  7. Reactive Programming doOnError -- START ------------------  ");
        log.info(" DoOnError를 이용해 에러 발생시 값올 호출하는 프로세스 ");

        Flux.just("timeout1", "timeout2", "timeout3", "timeout4")
                .flatMap(k -> Flux.just(String.valueOf(CallExternAPI.callAPI(String.valueOf(k)))))
                .onErrorResume(error -> Flux.error(new Exception("Value 7 Error!!")))
                .doOnError(e -> {
                    log.error(e.getMessage());
                    log.error("uh oh, Failed!");
                })
                .log()
                .subscribe(item -> log.info("Value 7 : {}", item), error -> log.error(error.getMessage()));

        log.info("  ");
        log.info("Reactor Error Handling ---------  7. Reactive Programming doOnError -- END ------------------  ");

        log.info("Reactor Error Handling ---------  8. Reactive Programming doOnError -- START ------------------  ");
        log.info(" 에러의 경우, 하나의 아이템이 에러가 발생하면 그다음 단계의 아이템을 실행되지 않음. 각 아이템별로 에러를 실행하게 하려면 flatMap를 사용한다.  ");

        Flux.just("timeout1", "timeout2", "timeout3", "timeout4")
                .flatMap(k -> Flux.just(String.valueOf(CallExternAPI.callAPI(String.valueOf(k)))))
                .onErrorResume(error -> Flux.error(new Exception("Value 8 Error!!")))
                .doOnError(e -> {

                    log.error("uh oh, Failed!");
                })
                .log()
                .subscribe(item -> log.info("Value 8 : {}", item), error -> log.error(error.getMessage()));

        log.info("  ");
        log.info("Reactor Error Handling ---------  8. Reactive Programming doOnError -- END ------------------  ");

        log.info("Reactor Error Handling ---------  9. Reactive Programming doFinally -- START ------------------  ");
        log.info(" doFinally 를 실행하는 처리, 에러가 발생한 이후 마지막으로 처리하는 함수 ");

        Flux.just("timeout5")
                .flatMap(k -> Flux.just(String.valueOf(CallExternAPI.callAPI(String.valueOf(k)))))
                .onErrorResume(error -> Flux.error(new Exception("Value 9 Error!!")))
                .doOnError(e -> {

                    log.error("uh oh, Failed!");
                })
                .log()
                .doFinally(type -> {
                    switch (type){
                        case CANCEL:
                            log.error("Call Error, so Cancelled!!");
                    }
                })
                .subscribe(item -> log.info("Value 9 : {}", item), error -> log.error(error.getMessage()));

        log.info("  ");
        log.info("Reactor Error Handling ---------  9. Reactive Programming doFinally -- END ------------------  ");

        log.info("Reactor Error Handling ---------  10. Reactive Programming doFinally -- START ------------------  ");
        log.info("  ");

        Flux<String> stringFlux1 =
                Flux.just("foo", "bar")
                .doOnSubscribe( s -> log.info("Value : {}",s))
                .doFinally( s -> {

                    if(s == SignalType.CANCEL){
                        log.info("doOnFinally Cancel : {}", s);
                    }
                })
                .take(1);

        stringFlux1.subscribe();

        log.info("  ");
        log.info("Reactor Error Handling ---------  10. Reactive Programming doFinally -- END ------------------  ");

        log.info("Reactor Error Handling ---------  11. Reactive Programming -- START ------------------  ");
        log.info("  ");

        try{
            Flux<String> stringFlux2 = Flux.using(
                    () -> null,
                    disposable -> Flux.just(disposable.toString()),
                    Disposable::dispose
            );

            stringFlux2.subscribe();
        }catch (Exception e){
            log.error(e.getMessage());
        }


        log.info("  ");
        log.info("Reactor Error Handling ---------  11. Reactive Programming -- END ------------------  ");

        log.info("Reactor Error Handling ---------  12. Reactive Programming : interval -- START ------------------  ");
        log.info(" Flux 에 의한 interval 처리 ");

        try{

            Flux<String> stringFlux3 = Flux.interval(Duration.ofMillis(250))
                    .map(input -> {
                        if( input < 3) return "task " + input;
                        throw new RuntimeException("boom");
                    })
                    .onErrorReturn("Uh Oh");

            stringFlux3.subscribe(System.out::println);
            Thread.sleep(2100);
        }catch (Exception exception){
            log.error(exception.getMessage());
        }

        log.info("  ");
        log.info("Reactor Error Handling ---------  12. Reactive Programming : interval -- END ------------------  ");

        log.info("Reactor Error Handling ---------  13. Reactive Programming : interval -- START ------------------  ");
        log.info(" Flux 에 의한 interval 처리, elapsed associates each value with the duration since previous value was emitted. ");

        try{
            Flux.interval(Duration.ofMillis(250))
                    .map(input -> {
                        log.info("input Value : {}", input);
                        if ( input < 3 ) return "tick" + input;
                        throw new RuntimeException("boom");
                    })
                    .retry(1)
                    .elapsed()
                    .subscribe(System.out::println, System.err::println );

            Thread.sleep(2100);

        }catch (Exception exception){
            log.error(exception.getMessage());
        }

        log.info("  ");
        log.info("Reactor Error Handling ---------  13. Reactive Programming : interval -- END ------------------  ");

        log.info("Reactor Error Handling ---------  14. Reactive Programming : retryWhen -- START ------------------  ");
        log.info(" retryWhen은 Flux에 의해서 아이템을 실행하고, 하나의 실행된 아이템에서 에러가 발생했을 때 해당 에러가 발생한 아이템을 아래의 코드에서는 retryWhen을 이용해서 3회 재시도를 실시한다.   ");

        // TODO Spring 2.5.2로 업그레이드 후 동작 안함 -> 수정 필요

        /*try{
            Flux.<String>error(new IllegalArgumentException())
                    .doOnError(System.out::println)
                    .retryWhen(companion -> companion.take(3))
                    .subscribe();
        }catch(Exception exception){
            log.error(exception.getMessage());
        }*/

        log.info("  ");
        log.info("Reactor Error Handling ---------  14. Reactive Programming : retryWhen -- END ------------------  ");

        log.info("Reactor Error Handling ---------  15. Reactive Programming : zipWith-- START ------------------  ");
        log.info("  ");


        // TODO Spring 2.5.2로 업그레이드 후 동작 안함 -> 수정 필요
       /* try{
            Flux.<String>error(new IllegalArgumentException())
                    .retryWhen(companion ->
                        companion.zipWith(Flux.range(1,4),
                                (error , index) -> {
                                    if ( index < 4) return index;
                                    else throw Exceptions.propagate(error);
                                })
                    ).subscribe();
        }catch (Exception exception){
            log.error(exception.getMessage());
        }*/

        log.info("  ");
        log.info("Reactor Error Handling ---------  15. Reactive Programming : zipWith -- END ------------------  ");

        log.info("Reactor Error Handling ---------  16. Reactive Programming : zipWith-- START ------------------  ");
        log.info("  ");

        try{
            Flux.just("foo")
                    .map(s -> { throw new IllegalArgumentException(s); })
                    .subscribe(v -> System.out.println("GOT VALUE"),
                            e -> System.err.println("ERROR : " + e));
        }catch (Exception exception){
            log.error(exception.getMessage());
        }

        log.info("  ");
        log.info("Reactor Error Handling ---------  16. Reactive Programming : zipWith -- END ------------------  ");

        log.info("Reactor Error Handling ---------  17. Reactive Programming -- START ------------------  ");
        log.info("  ");

        try{
            Flux<String> converted = Flux.range(1, 10)
                    .map( i -> {
                        try { return convert(i); }
                        catch (IOException ioException) { throw Exceptions.propagate(ioException); }
                    });

            converted.subscribe(
                    v -> System.out.println("RECEIVED: " + v),
                    e -> {
                        if (Exceptions.unwrap(e) instanceof IOException) {
                            System.out.println("Something bad happened with I/O");
                        } else {
                            System.out.println("Something bad happened");
                        }
                    }
            );
        }catch (Exception exception){
            log.error(exception.getMessage());
        }

        log.info("  ");
        log.info("Reactor Error Handling ---------  17. Reactive Programming -- END ------------------  ");


    }

    public static String convert(int i) throws IOException {
        if( i > 3){
            throw new IOException("boom " + i);
        }
        return "OK " + i;
    }

    private static String doSecondTransform(Object v) {
        return String.valueOf(v);
    }

    private static Object doSomethingDangerous(Integer v) {

        int testValue;

        if( v == 5){
            testValue = v / 0;
        }

        return v;
    }

    public static class Dangerous{
        private static Object doSomethingDangerous(Integer v){
            int testValue;

            if( v == 5){
                testValue = v / 0;
            }

            return v;
        }
    }

    public static class CallExternAPI {
        private static boolean callAPI(Object key){

            String value = String.valueOf(key);

            switch (value){
                case "key1" :
                    return true;
                case "key2" :
                    return false;
                default:
                    int good = 10 / 0;
                    return false;
            }
        }
    }

    public static class MyWrapper{
        public static String fromError(Throwable exception){
            return exception.getMessage();
        }
    }

}
