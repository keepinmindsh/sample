package lines.sample;

import com.google.common.util.concurrent.*;

import java.util.concurrent.Executors;

public class ListenableFuture02 {
    public static void main(String[] args) {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

        ListenableFuture<Explosion> explosion = service.submit(
                () -> null);

        Futures.addCallback(
                explosion,
                new FutureCallback<Explosion>() {
                    // we want this handler to run immediately after we push the big red button!
                    public void onSuccess(Explosion explosion) {
                        //walkAwayFrom(explosion);
                    }
                    public void onFailure(Throwable thrown) {
                        //battleArchNemesis(); // escaped the explosion!
                    }
                },
                service);
    }
}

class Explosion {

}
