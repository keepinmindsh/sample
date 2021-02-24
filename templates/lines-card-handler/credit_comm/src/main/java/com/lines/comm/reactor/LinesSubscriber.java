package com.lines.comm.reactor;

import java.util.concurrent.Flow;

public class LinesSubscriber implements Flow.Subscriber {
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Object o) {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }
}
