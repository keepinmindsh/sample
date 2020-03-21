package java8.basic04;

@FunctionalInterface
public interface CustomFuntionalInterface<T, U, R> {
    public R apply(T value1, U value2);
}


