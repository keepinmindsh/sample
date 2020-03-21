package sample.Parallel;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@ThreadSafe
public class SemaphoreOnLock {
    public final Lock lock = new ReentrantLock();

    private final Condition permitAvaialbe = lock.newCondition();


    @GuardedBy("lock") private int permits;

    SemaphoreOnLock ( int initialPermits){
        lock.lock();
        try{
            permits = initialPermits;
        }finally {
            lock.unlock();
        }
    }

    public void acquire()  throws InterruptedException {
        lock.lock();

        try {
           while ( permits <= 0)
               permitAvaialbe.await();
           --permits;
        } finally {
            lock.unlock();
        }
    }

    public void release() {
        lock.lock();
        try {
            ++permits;
            permitAvaialbe.signal();
        }finally {
            lock.unlock();
        }
    }

}
