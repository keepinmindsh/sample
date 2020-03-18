package designpattern.gof_proxy.sample03;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class TextFileProvider {
    public static List<SecretTextFile> getSecretTextFile(int start, int end) {
        return IntStream.range(start, end)
                .mapToObj(i -> new SecretTextFile(String.valueOf(i)))
                .collect(Collectors.toList());
    }

    public static List<ProxyTextFile> getProxyTextFile(int start, int end) {
        return IntStream.range(start, end)
                .mapToObj(i -> new ProxyTextFile(String.valueOf(i)))
                .collect(Collectors.toList());
    }
}
