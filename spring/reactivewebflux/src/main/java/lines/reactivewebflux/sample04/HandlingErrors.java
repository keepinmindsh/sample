package lines.reactivewebflux.sample04;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;

@Slf4j
public class HandlingErrors {
    public static void main(String[] args) {
        Flux.just(1, 2, 0)
            .map(item -> "100 / " + item + " = " + ( 100 / item )).log()
            .onErrorReturn("Divded by Zero : (").subscribe(item -> log.info(item), error -> log.error(error.getMessage())) ;

        Flux<String> stringFlux = Flux.range(1, 10)
                .map(v -> doSomethingDangerous(v) )
                .log()
                .map(v -> doSecondTransform(v));

        stringFlux.subscribe(value -> log.info("Received  : {} ", value),
                             error -> log.error("CAUGHT : {} ", error.getMessage())
                );

        Flux.just(10, 5)
                .map(Dangerous::doSomethingDangerous)
                .onErrorReturn("Divided By Zero!").subscribe(item -> log.info("Value 1 : {}", item), error -> log.error(error.getMessage()) );


        Flux.just(10, 5)
                .map(Dangerous::doSomethingDangerous)
                .onErrorReturn(error -> error.getMessage().equals("/ by zero") , "recovered5"  ).subscribe(item -> log.info("Value 2 : {}", item), error -> log.error(error.getMessage()) );

        Flux.just("key1", "key2", "key3")
                .flatMap(k -> Flux.just(k).map(item -> String.valueOf(CallExternAPI.callAPI(item))).onErrorResume(e -> Flux.just("key1") ) )
                .log()
                .subscribe(item -> log.info("Value 4 : {}", item), error -> log.error(error.getMessage()));


        Flux.just("key1", "key2", "key3")
                .map(item -> String.valueOf(CallExternAPI.callAPI(item))).onErrorResume(e -> Mono.just(MyWrapper.fromError(e)))
                .log()
                .subscribe(item -> log.info("Value 5 : {}", item), error -> log.error(error.getMessage()));


        Flux.just("timeout1")
                .flatMap(k -> Flux.just(String.valueOf(CallExternAPI.callAPI(String.valueOf(k)))))
                .onErrorResume(error -> Flux.error(new Exception("Value 6 Error!!")))
                .log()
                .subscribe(item -> log.info("Value 6 : {}", item), error -> log.error(error.getMessage()));

        Flux.just("timeout3")
                .flatMap(k -> Flux.just(String.valueOf(CallExternAPI.callAPI(String.valueOf(k)))))
                .onErrorResume(error -> Flux.error(new Exception("Value 7 Error!!")))
                .doOnError(e -> {
                    log.error(e.getMessage());
                    log.error("uh oh, Failed!");
                })
                .log()
                .subscribe(item -> log.info("Value 7 : {}", item), error -> log.error(error.getMessage()));

        Flux.just("timeout4")
                .flatMap(k -> Flux.just(String.valueOf(CallExternAPI.callAPI(String.valueOf(k)))))
                .onErrorResume(error -> Flux.error(new Exception("Value 8 Error!!")))
                .doOnError(e -> {

                    log.error("uh oh, Failed!");
                })
                .log()
                .subscribe(item -> log.info("Value 8 : {}", item), error -> log.error(error.getMessage()));

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
