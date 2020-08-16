package lines.reactivewebflux.MVCwithMonoFluxStream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@Slf4j
@RestController
public class SpringBootSampleApplication {

    @GetMapping("/event/{id}")
    Mono<Event> hello(@PathVariable long id){
        return Mono.just(new Event(id, "event "+ id));
    }

    @GetMapping("/event")
    Mono<List<Event>> event(){
        return Mono.just(Arrays.asList(new Event(1L, "event1"), new Event(1L, "event2")));
    }

    @GetMapping("/events1")
    Flux<Event> events1(){
        return Flux.just(new Event(1L, "event1"), new Event(1L, "event2"));
    }

    @GetMapping(value="/events2", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Event> events2(){
        return Flux.just(new Event(1L, "event1"), new Event(1L, "event2"));
    }

    @GetMapping(value="/events3", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Event> events3(){

        Stream<Event> stream = Stream.generate(() -> new Event(System.currentTimeMillis(), "value"));

        return Flux.fromStream(stream).delayElements(Duration.ofSeconds(1)).take(10);
    }

    @GetMapping(value="/events4", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Event> events4(){
        //sink -> sink.next(new Event(System.currentTimeMillis(), "Value"))
        return Flux
                .<Event, Long>generate(() -> 1L, ( id, sink) ->{
                    sink.next(new Event(id, "Value" + id) );
                    return id + 1;
                })
                .delayElements(Duration.ofSeconds(1))
                .take(10);
    }

    @GetMapping(value="/events5", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Event> events5(){
        Flux<Event> eventFlux = Flux
                .<Event, Long>generate(() -> 1L, ( id, sink) ->{
                    sink.next(new Event(id, "Value" + id) );
                    return id + 1;
                })
                .delayElements(Duration.ofSeconds(1));

        Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));

        return Flux.zip(eventFlux, interval).map(tu -> tu.getT1());
    }

    @GetMapping(value="/events6", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Event> events6(){
        Flux<String> eventFlux = Flux.generate(sink -> sink.next("Value"));

        Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));

        return Flux.zip(eventFlux, interval).map(tu -> new Event(tu.getT2(), tu.getT1())).take(10);
    }


    @GetMapping("/eventsByIterable")
    Flux<Event> eventsByIterable(){
        return Flux.fromIterable(Arrays.asList(new Event(1L, "event1"), new Event(1L, "event2")));
    }



    public static void main(String[] args) {
        SpringApplication.run(SpringBootSampleApplication.class, args);
    }

    @Data
    @AllArgsConstructor
    public static class Event {
        long id;
        String value;
    }
}
