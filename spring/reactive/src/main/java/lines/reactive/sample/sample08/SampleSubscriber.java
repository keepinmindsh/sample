package lines.reactive.sample.sample08;

import com.reactive.reactive.sample.sample08.handler.CommandHandler;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SampleSubscriber implements Subscriber<CommandHandler> {

    private final ExecutorService executorService;

    List<Future<?>> futures = new ArrayList<>();

    public SampleSubscriber(int executeCount){
        this.executorService = Executors.newFixedThreadPool(executeCount);
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(1);
    }

    @Override
    public void onNext(CommandHandler commandHandler) {
        futures.add(executorService.submit(commandHandler::StartAPICall));
    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {
        for(Future<?> future : futures) {
            try {
                future.get();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }
}
