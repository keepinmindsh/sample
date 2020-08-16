package lines.reactivewebflux.ProjectReactorCoreSample.sample05;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class BackPressureSample {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();

        Flux.just(1,2,3,4,5,6,7,8,9)
                .log()
                .subscribe(new Subscriber<Integer>() {

                    private Subscription subscription;

                    int onNextAmount;

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription = subscription;
                        subscription.request(2);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        integerList.add(integer);
                        onNextAmount ++;
                        if(onNextAmount % 2 == 0){
                            subscription.request(2);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
