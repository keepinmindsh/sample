package lines.reactivewebflux.ProjectReactorCoreSample.sample;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Sample01 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "the",
                "quick",
                "brown",
                "fox",
                "jumped",
                "over",
                "the",
                "lazy",
                "dog"
        );

        Flux<String> fewWords = Flux.just("Hello", "World");
        Flux<String> manyWords = Flux.fromIterable(words);

        fewWords.subscribe(System.out::println);
        System.out.println();
        manyWords.subscribe(System.out::println);

        Flux<String> manyLetters = Flux
                .fromIterable(words)
                .flatMap(word -> Flux.fromArray(word.split("")))
                .distinct()
                .sort()
                .zipWith(Flux.range(1, Integer.MAX_VALUE),
                        (string, count) -> String.format("%2d. %s", count, string));

        manyLetters.subscribe(System.out::println);

        Mono<String> missing = Mono.just("s");
        Flux<String> allLetters = Flux
                .fromIterable(words)
                .flatMap(word -> Flux.fromArray(word.split("")))
                .concatWith(missing)
                .distinct()
                .sort()
                .zipWith(Flux.range(1, Integer.MAX_VALUE),
                        (string, count) -> String.format("%2d. %s", count, string));

        allLetters.subscribe(System.out::println);

        Flux<String> helloPauseWorld =
                Mono.just("Hello")
                        .concatWith(
                                Mono.just("world")
                                .delaySubscription(Duration.ofMillis(5000)));

        helloPauseWorld.subscribe(System.out::println);

        Flux<String> helloPauseWorldStream =
                Mono.just("Hello")
                        .concatWith(
                                Mono.just("world")
                                        .delaySubscription(Duration.ofMillis(5000)));

        helloPauseWorldStream.toStream()
                .forEach(System.out::println);

        Mono<String> a = Mono.just("oops I'm late")
                .delaySubscription(Duration.ofMillis(5000));
        Flux<String> b = Flux.just("let's get", "the party", "started")
                .delaySequence(Duration.ofMillis(5000));

        Flux.first(a, b)
                .toIterable()
                .forEach(System.out::println);
    }
}
