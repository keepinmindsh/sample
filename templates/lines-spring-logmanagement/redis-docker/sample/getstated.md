**docker pull redis**

Docker를 실행하여 Redis서버를 올리고 기본 포트인 6379로 실행됩니다.

-d 옵션은 백그라운드에서 실행하겠다는 의미이며

-p 옵션은 외부에서 해당 포트로 접속할 수 있게 열어둔다는 의미입니다.

**docker run --name some-redis -d -p 6379:6379 redis**
