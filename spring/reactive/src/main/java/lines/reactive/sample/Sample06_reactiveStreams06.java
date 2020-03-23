package lines.reactive.sample;


import lines.reactive.sample.sample06.Command;
import lines.reactive.sample.sample06.CustomPublisher;
import lines.reactive.sample.sample06.CustomSubscriber;
import lines.reactive.sample.sample06.IntegerSumCommand;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sample06_reactiveStreams06 {
    public static void main(String[] args) {
        // 1000개의 난수 배열을 가진 아이템 생성 - 각각을 합쳐

        BlockingQueue<Command> blockingQueue = new ArrayBlockingQueue<Command>(5000);

        for (int i = 0; i < 5000; i++) {

            IntStream intStream = new Random().ints();

            List<Integer> integerList = intStream.limit(1000).boxed().collect(Collectors.toList());

            Command command = new IntegerSumCommand(integerList);

            blockingQueue.add(command);
        }

        // Publisher
        Publisher publisher = new CustomPublisher(blockingQueue);

        // Subscriber
        Subscriber subscriber = new CustomSubscriber();

        // Start !
        publisher.subscribe(subscriber);
    }
}
