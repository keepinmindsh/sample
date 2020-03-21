package java8.basic01;

import java.util.function.Function;

@FunctionalInterface
public interface FooWithFunction<T> {
    public String add(String string, Function<T, T> fn);
}
