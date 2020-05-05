package lines.reactivewebflux.sample04;

import reactor.core.publisher.Flux;

import java.util.List;

public class MultiThread {
    public static void main(String[] args) {
        Flux<String> stringFlux = Flux.create(sink -> {
//            myEventProcessor.register(
//                    new MyEventListener<String>() {
//
//                        public void onDataChunk(List<String> chunk) {
//                            for(String s : chunk) {
//                                sink.next(s);
//                            }
//                        }
//
//                        public void processComplete() {
//                            sink.complete();
//                        }
//                    });
        });

        Flux<String> stringFlux1 = Flux.create(sink -> {
//            myEventProcessor.register(
//                    new SingleThreadEventListener<String>() {
//
//                        public void onDataChunk(List<String> chunk) {
//                            for(String s : chunk) {
//                                sink.next(s);
//                            }
//                        }
//
//                        public void processComplete() {
//                            sink.complete();
//                        }
//
//                        public void processError(Throwable e) {
//                            sink.error(e);
//                        }
//                    });
        });

        Flux<String> stringFlux2 = Flux.create(sink -> {
//            myMessageProcessor.register(
//                    new MyMessageListener<String>() {
//
//                        public void onMessage(List<String> messages) {
//                            for(String s : messages) {
//                                sink.next(s);
//                            }
//                        }
//                    });
//            sink.onRequest(n -> {
//                List<String> messages = myMessageProcessor.getHistory(n);
//                for(String s : message) {
//                    sink.next(s);
//                }
//            });
        });

        Flux<String> bridge = Flux.create(sink -> {
//            sink.onRequest(n -> channel.poll(n))
//                    .onCancel(() -> channel.cancel())
//                    .onDispose(() -> channel.close());
        });
    }

    public interface MyEventListener<T> {
        void onDataChunk(List<T> chunk);
        void processComplete();
    }
}
