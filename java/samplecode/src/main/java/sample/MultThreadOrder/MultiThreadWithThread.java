package sample.MultThreadOrder;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class MultiThreadWithThread {
    public static void main(String[] args) {

        CallThread callThread1 = new CallThread(13);
        CallThread callThread2 = new CallThread(17);
        CallThread callThread3 = new CallThread(18);

        callThread1.setPriority(1);
        callThread1.start();

        callThread2.setPriority(2);
        callThread2.start();

        callThread3.setPriority(3);
        callThread3.start();

    }
}

class CallThread extends Thread{

    private final int intValue;

    public CallThread(int intValue){
        this.intValue = intValue;
    }

    @Override
    public void run() {
        StaticController.printIntValue(intValue);
    }
}

@Slf4j
class StaticController extends Thread{

    private static int intValue = 10;

    private static List<Integer> integerList;

    private static Lock lock = new ReentrantLock();

    public static void printIntValue(int value){
        lock.lock();

        intValue = value;

        log.info("Int Value : {}", intValue);

        lock.unlock();
    }

}
