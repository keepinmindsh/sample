package lines.reactive.sample.sample05;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    private static final AtomicInteger atomicInteger = new AtomicInteger();

    public static int incrementAndGet(){
        return atomicInteger.incrementAndGet();
    }

    public static int get(){
        return atomicInteger.get();
    }
}
