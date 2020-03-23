package lines.reactive.sample;

import com.reactive.reactive.sample.sample07.*;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sample07_reactiveStreams07 {

    public static void main(String[] args) {
        // 1000개의 난수 배열을 가진 아이템 생성 - 각각을 합쳐

        BlockingQueue<Command> blockingQueue = new ArrayBlockingQueue<Command>(500);

        for (int i = 0; i < 500; i++) {

            IntStream intStream = new Random().ints();

            List<Integer> integerList = intStream.limit(1000).boxed().collect(Collectors.toList());

            Command command = new IntegerHandlerCommand(integerList);

            blockingQueue.add(command);
        }

        // Publisher
        Publisher<Command> publisher = new CustomPublisher(blockingQueue);

        Publisher<Command> publisher1 = new FilterPublisher(publisher);

        // Subscriber
        Subscriber subscriber = new CustomSubscriber();

        // Start !
        publisher1.subscribe(subscriber);
    }

}
