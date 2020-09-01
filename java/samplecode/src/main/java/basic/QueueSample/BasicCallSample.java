package basic.QueueSample;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Slf4j
public class BasicCallSample {
    public static void main(String[] args) {
        BlockingQueue<String> stringBlockingQueue = new ArrayBlockingQueue<>(10);

        stringBlockingQueue.add("Value");

        log.info("Length : {}" , stringBlockingQueue.size());

        stringBlockingQueue.peek();

        log.info("Length : {}", stringBlockingQueue.size());

        stringBlockingQueue.poll();

        log.info("Length : {}", stringBlockingQueue.size());
    }
}
