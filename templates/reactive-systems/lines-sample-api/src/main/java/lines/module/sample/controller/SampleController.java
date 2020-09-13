package lines.module.sample.controller;

import lines.module.sample.model.RequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class SampleController {

    @PostMapping(value = "/test1")
    Mono<String> getTest01(@RequestBody RequestVO transfer) {
        log.info("=>{}", transfer);
        return Mono.just("hello-withdraw");
    }
}
