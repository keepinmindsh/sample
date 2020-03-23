package lines.reactive.sample.sample09.reactive;

import com.reactive.reactive.sample.sample09.command.handler.CommandHandler;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CustomSubsriber implements Subscriber<CommandHandler> {

    private ExecutorService executorService = Executors.newCachedThreadPool();

    private Future future;

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(1);
    }

    @Override
    public void onNext(CommandHandler commandHandler) {
        future = executorService.submit(commandHandler::CommandExecute);
    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {

        try {
            future.get();
        } catch ( Exception e){
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
