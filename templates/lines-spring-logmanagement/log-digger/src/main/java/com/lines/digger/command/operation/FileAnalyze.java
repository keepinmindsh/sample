package com.lines.digger.command.operation;

import com.lines.lib.operation.Operate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.springframework.web.reactive.function.server.ServerRequest;

@RequiredArgsConstructor
@Slf4j
public class FileAnalyze implements Operate {

    private final ServerRequest serverRequest;

    // TODO Error 값을 찾지 못함 - spark 사용 용례 공부 필요  - http://localhost:7000/file/analyze?path=/Users/dream/test/text.txt
    // TODO http://spark.apache.org/docs/latest/rdd-programming-guide.html

    @Override
    public Object operate() {

        long numAsError = 0;
        long numAsWarning = 0;

        if(serverRequest.queryParam("filePath").isPresent()){
            String logFile = serverRequest.queryParam("filePath").get();

            SparkConf conf = new SparkConf().setAppName("Lines Analyze Application");

            JavaSparkContext sc = new JavaSparkContext(conf);
            JavaRDD<String> logData = sc.textFile(logFile);

            numAsError = logData.filter((Function<String, Boolean>) s -> s.contains("error")).count();

            numAsWarning = logData.filter((Function<String, Boolean>) s -> s.contains("warning")).count();

            log.info("Error Count : {}, Warning Count : {}", numAsError, numAsWarning);

            sc.stop();
        }

        return numAsError;
    }
}
