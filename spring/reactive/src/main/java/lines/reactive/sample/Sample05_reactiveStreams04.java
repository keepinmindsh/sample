package lines.reactive.sample;


import lines.reactive.sample.sample05.Command;
import lines.reactive.sample.sample05.CustomPublisher;
import lines.reactive.sample.sample05.CustomSubscriber;
import lines.reactive.sample.sample05.InsertToDataBaseCommand;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sample05_reactiveStreams04 {

    public static void main(String[] args) {

        BlockingQueue<Command> blockingQueue = new ArrayBlockingQueue<Command>(2000);

        for (int i = 0; i < 2000 ; i++) {
            IntStream randomValueList = new Random().ints();

            List<Integer> integerList = randomValueList.limit(1000).boxed().collect(Collectors.toList());

            Command command = new InsertToDataBaseCommand(integerList);

            blockingQueue.add(command);
        }

        Publisher publisher = new CustomPublisher(blockingQueue);

        Subscriber subscriber = new CustomSubscriber();

        publisher.subscribe(subscriber);
    }
}
