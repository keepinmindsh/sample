Study 

# 모든 API의 근간은 Socket으로 구성되어 있다. 
 
다만 TCP Socket을 통해 들어오는 데이터를 프레임워크 및 라이브러리로 기본적인 프로세스를 표준화하여 받을 수 있게 구성한 것일 뿐이다.

# 파일 경로를 정의하는 방식 

- IDEA 또는 Eclipse에서 빌드가 되었을 때 클래스의 위치를 고려한다면 파일의 위치를 가져오는 방식에 대해서 반드시 고려되어야 한다.

아래의 코드에서 가장 중요한 부분은 Resource 부분이 src/main/resource 까지만 주어진다는 것. 그 이후 경로의 시작은 / 를 반드시 붙여야함. 

   - 첫번째 방법 

```java

Class clazz = RequestHandler.class;
body = Files.readAllBytes(new File(clazz.getResource("/templates/index.html").getFile()).toPath());

```

   - 두번재 방법

```java

body = RequestHandler
        .class
        .getResourceAsStream("/templates/index.html")
        .readAllBytes();

```

참고 링크 : <https://www.baeldung.com/reading-file-in-java>


 
