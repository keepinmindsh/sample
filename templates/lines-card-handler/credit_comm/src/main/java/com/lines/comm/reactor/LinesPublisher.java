package com.lines.comm.reactor;

import java.util.concurrent.Flow;

public class LinesPublisher implements Flow.Publisher {
    @Override
    public void subscribe(Flow.Subscriber subscriber) {
        subscriber.onSubscribe(new LinesSubscription());
    }
}
