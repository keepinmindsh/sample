

### localhost:8080/stream - Execute Result

```shell

$ curl -i localhost:8080/stream

D:\GIT\01_GIT\02_sample\templates\spring-webflux-sample>curl -i localhost:8080/stream
HTTP/1.1 200 OK
transfer-encoding: chunked
Content-Type: application/json

[{"value":0},{"value":1},{"value":2},{"value":3},{"value":4},{"value":5},{"value":6},{"value":7},{"value":8},{"value":9}]

```


### localhost:8080 - Execute Result 

```shell
$ curl -i localhost:8080

D:\GIT\01_GIT\02_sample\templates\spring-webflux-sample>curl -i localhost:8080
HTTP/1.1 200 OK
transfer-encoding: chunked
Content-Type: text/plain;charset=UTF-8

HelloWorld
D:\GIT\01_GIT\02_sample\templates\spring-webflux-sample>

```

- 참조 : <http://devkuma.com/pages/1514>