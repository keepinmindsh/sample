# JPA

### JPA 프로그래밍 

- JPA 는 인터페이스의 모음
- JPA는 애플리케이션과 JDBC 사이에서 동작

### JPA를 왜 사용해야 하는가?

- SQL 중심적인 개발애서 객체 중심으로 개발 
  - 마치 자바 Collection에 값을 넣었다 가져왔다하는 역할들과 같음 
- 생산성, 유지보수, 패러다임의 불일치 해결, 성능, 데이터 접근 추상화와 벤더 독립성, 표준
  - JPA와 비교하기 
    - 동일한 트랜잭션에서 조회한 엔티티는 같음을 보장 
  - JPA 성증 최적화 기능 
    - 1차캐시와 동일성 보장 
      - 같은 트랜잭션안에서는 같은 엔티티를 반환
      - DB Isolation Level이 Read Commit 이어도 애플리케이션에서 Repeatable Read 보장 
    - 트랜잭션을 지원하는 쓰기 지연 : 설정에 의해서 처리 가능 
      - 트랜잭션을 커밋할 때까지 INSERT SQL 모음
      - JDBC Batch SQL 기능을 사용해서 SQL 전송
    - 지연 로딩 : 설정에 의해서 처리 가능 
      - 객체가 실제 사용될 때 로딩 

### ORM은 객체와 RDB 두 기둥 위에 있는 기술 

- 객체지향과 RDB의 적절한 Balance를 잘 맞춰야 한다. 
- RDB에 대한 이해가 더욱더 중요함. 

> https://www.inflearn.com/course/ORM-JPA-Basic/lecture/21683?tab=curriculum&volume=1.00&quality=auto
> https://joont92.github.io/db/%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98-%EA%B2%A9%EB%A6%AC-%EC%88%98%EC%A4%80-isolation-level/
> https://effectivesquid.tistory.com/entry/%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4-Isolation-Level