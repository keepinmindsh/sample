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

# Reqeust의 구성 

Header와 Body를 구성하는 영역은 한줄의 공백으로 구분된다. 예를 들면 헤더 정보가 들어오고 그 아래로 내가 전송한 데이터가 들어오는 방식이다.

여기에서 Body 영역으로 구분되는 한 줄의 공백으로 파라미터가 구분되어야 할 때, HTTP Method는 POST 일 경우이다. 

```shell

Host: localhost:8080 true
Connection: keep-alive true
Content-Length: 73 true
Cache-Control: max-age=0 true
sec-ch-ua: "Chromium";v="92", " Not A;Brand";v="99", "Google Chrome";v="92" true
sec-ch-ua-mobile: ?0 true
Upgrade-Insecure-Requests: 1 true
Origin: http://localhost:8080 true
Content-Type: application/x-www-form-urlencoded true
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.107 Safari/537.36 true
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9 true
Sec-Fetch-Site: same-origin true
Sec-Fetch-User: ?1 true
Sec-Fetch-Dest: document true
Referer: http://localhost:8080/user/form_post.html true
Accept-Encoding: gzip, deflate, br true
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7 true

name=1431243&email=keepinmindsh%40gmail.com&name=asdfmin&name=12321342134

```

### Header 영역

HTTP 헤더는 HTTP 본문(body) 및 요청/응답에 대한 정보를 포함한다. 

- 일반 헤더 

- 요청 / 응답 헤더

- 엔터티 헤더 

### Body 영역

데이터 컨텐츠 / 메세지 본문이 나타난다. 콘텐츠는 요청한 리소스에 따라 HTML 코드, 이미지, CSS 스타일 시트 또는 Javascript 파일이 포함될 수 있다. 

# Response의 구성

### 응답 코드의 정의 

하이퍼텍스트 전송 프로토콜(HTTP) 의 302 Found 리다이렉트 상태 응답 코드는 클라이언트가 요청한 리소스가 헤더에 주어진 URL에 일시적으로 이동되었음을 가리킨다. 

- 301, Permanently Moved 

 Permanently라는 뜻이 영구히, 영구적인 이라는 뜻이므로, 영구적으로 이동한다는 것이다. 요청된 리소스가 영구적으로 이동 페이지로 이동되었다는 것이다.

- 302, Temporarily Moved
 
 Temporarily라는 뜻이 임시적, 임시적인 이라는 뜻이므로, 임시적으로 이동했다는 것을 나타냅니다. 요청된 리소스가 임시적으로 이동 페이지로 이동되었다는 것이다.
 
 
 

참고 링크 : <https://www.baeldung.com/reading-file-in-java>
참고 링크 : <https://blueyikim.tistory.com/1999>
참고 링크: <https://im-first-rate.tistory.com/73> [웃으면 1류다]


 
