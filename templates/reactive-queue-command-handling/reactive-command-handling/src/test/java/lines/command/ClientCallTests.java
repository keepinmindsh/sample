package lines.command;

import lines.model.RequestVO;
import lines.model.ResponseVO;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientCallTests {

    private static ExecutorService executorService = Executors.newFixedThreadPool(100);

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            executorService.submit(() -> {

                RestTemplate restTemplate = new RestTemplate();

                RequestVO requestVO = new RequestVO();

                requestVO.setItemKey(String.valueOf(Math.random()));
                requestVO.setCommandArgs("Content Check");

                restTemplate.postForEntity("http://localhost:8080/request/command", requestVO, RequestVO.class);
            });
        }

        executorService.shutdown();
    }
}
