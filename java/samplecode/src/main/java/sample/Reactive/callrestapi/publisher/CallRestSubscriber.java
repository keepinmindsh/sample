package sample.Reactive.callrestapi.publisher;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import sample.Reactive.callrestapi.command.URLCommand;
import sample.Reactive.callrestapi.vo.ParameterVO;
import sample.Reactive.callrestapi.builder.ProcessBuilder;


import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallRestSubscriber implements Subscriber<HashMap<String, Object>> {

    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    private int count;

    public CallRestSubscriber(int count){
        this.count = count;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(count);
    }

    @Override
    public void onNext(HashMap<String, Object> mapItem) {
        executorService.execute(() -> {
            ProcessBuilder.Builder urlBuilder = new ProcessBuilder.Builder();

            urlBuilder.setParameterVO(new ParameterVO());
            urlBuilder.setCommand(new URLCommand<String>());
            urlBuilder.setPath("callApiURL");
            urlBuilder.setUrl("http://localhost/");

            Object responseResult = urlBuilder.build().callCommandProcess();

            System.out.println(responseResult);
        });
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("에러가 발생하였습니다.");
    }

    @Override
    public void onComplete() {
        System.out.println("완료 되었습니다.");
    }
}
