RestTemplate VS WebClient

RestTemplate - Blocking Client 

 Java Servlet API를 사용하기 때문에 동기화, 블록킹을 기반으로 한다. 

AsyncRestTemplate 

 ListenableFuture를 활용하여 RestTemplate 이 블로킹 문제를 해소한 방식이다. 

Webclient - Non Blocking Client 

 Spring 리액티브 프레임워크에서 제공하는 논 블락킹 프레임워크에 따라 동작한다. 

https://jeong-pro.tistory.com/187
