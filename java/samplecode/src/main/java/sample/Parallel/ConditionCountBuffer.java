package sample.Parallel;

import javax.annotation.concurrent.GuardedBy;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 명시적인 조건 큐를 활용해 작성한 크기가 제한된 버퍼링
public class ConditionCountBuffer<T> {
    protected final Lock lock = new ReentrantLock();

    private final Condition notFull = lock.newCondition();

    private final Condition notEmtpty = lock.newCondition();

    private final int BUFFER_SIZE = 1024;

    @GuardedBy("lock")
    private final T[] items = (T[]) new Object[BUFFER_SIZE];
    @GuardedBy("lock") private int tail, head, count;

    public void put(T x) throws InterruptedException {
        lock.lock();

        try {
            while ( count == items.length){
                notFull.await();
            }

            items[tail] = x;
            if(++tail == items.length){
                tail = 0;
            }
            notEmtpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        lock.lock();

        try{
            while ( count == 0)
                notEmtpty.await();

            T x = items[head];
            items[head] = null;
            if(++head == items.length)
                head = 0;
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}
