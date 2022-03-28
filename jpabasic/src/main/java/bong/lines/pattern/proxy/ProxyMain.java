package bong.lines.pattern.proxy;

public class ProxyMain {

    public static void main(String[] args) {
        Selector selector = new ProxySelector(new QuerySelector(), Code.LAZY);

        selector.select();
    }
}
