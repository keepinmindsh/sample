package lines.reactive.sample.sample07;

public class Counter {
    private static int count = 0;

    public synchronized static int addAndGet(){
        return count ++;
    }

    public synchronized static int get(){
        return count;
    }
}
