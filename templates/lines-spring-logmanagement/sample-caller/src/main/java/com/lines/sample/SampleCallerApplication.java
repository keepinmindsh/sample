package com.lines.sample;

import com.lines.model.LogRQVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class SampleCallerApplication {

    private static ScheduledExecutorService EXECUTOR_SERVICE1 = Executors.newSingleThreadScheduledExecutor();
    private static ScheduledExecutorService EXECUTOR_SERVICE2 = Executors.newSingleThreadScheduledExecutor();

    private static final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        SpringApplication.run(SampleCallerApplication.class);

        EXECUTOR_SERVICE1.scheduleAtFixedRate(() -> {

            List<String> dataList =  Stream.iterate(0 , i ->  i + 1).limit(187).map(intValue -> { return "Value" + intValue; } ).collect(Collectors.toList());

            dataList.forEach(value -> {
                LogRQVO logRQVO = new LogRQVO();

                logRQVO.setContent(value);

                String personResultAsJsonStr = restTemplate.postForObject("http://localhost:9090/v1/log", logRQVO, String.class);

                log.info("Response Reulst : {}" , personResultAsJsonStr );

            });

        }, 0, 10, TimeUnit.SECONDS);


        EXECUTOR_SERVICE2.scheduleAtFixedRate(() -> {

            List<String> dataList =  Stream.iterate(0 , i ->  i + 1).limit(67).map(intValue -> { return "Value" + intValue; } ).collect(Collectors.toList());

            dataList.forEach(value -> {
                LogRQVO logRQVO = new LogRQVO();

                logRQVO.setContent(value);

                String personResultAsJsonStr = restTemplate.postForObject("http://localhost:9090/v1/log", logRQVO, String.class);

                log.info("Response Reulst : {}" , personResultAsJsonStr );

            });

        }, 1, 4, TimeUnit.SECONDS);
    }
}
