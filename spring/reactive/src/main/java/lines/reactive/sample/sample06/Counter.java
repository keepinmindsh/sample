package lines.reactive.sample.sample06;

public class Counter {

    //private static final AtomicInteger atomicInteger = new AtomicInteger();

    private static int count = 0;

    public synchronized static int addAndGet(){
        return count ++;
    }

    public synchronized static int get(){
        return count;
    }
}
