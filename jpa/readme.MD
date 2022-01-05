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

### JPA Hello World 

- Environments
  - https://www.h2database.com/html/main.html 를 이용한 H2 Database 구성 
  - JPA Java Project 구성시 Maven 모듈 ( Gradle Or Maven )
    - https://mvnrepository.com/artifact/org.hibernate/hibernate-entitymanager
    - https://mvnrepository.com/artifact/com.h2database/h2
  - persistence.xml 설정 
    - jpa의 경우, 기본적인 설정 파일을 필요로 함. 순수 자바 프로젝트에서 사용할 경우 META-INF 하위에 persistence.xml 를 위치시키는 것이 중요함.
      - 항목별 설명
        - hibernate.dialect : 데이터베이스 방언, 다양하게 존재하는 DB의 DDL,DML 등의 특성, 고유한 기능에 맞춰 사용할 수 있게 해주는 설정
    - javax. ~ : 표준에서 제정한 것 
    - hibernate. ~ : 하이버네이트 전용 옵션
      - hibernate.show_sql : query를 출력함
      - hibernate.format_sql : sql을 예쁘게
      - hibernate.use_sql_comments : 쿼리 실행사유를 표시

### JPQL 

- 테이블이 아닌 객체를 대상으로 검색하는 객체 지향 쿼리 
- SQL를 추상화해서 특정 데이터 베이스 SQL에 의존 안함 
- JPQL을 한마디로 정의하면 객체 지향 SQL
- 복합적으로 연관되어 있는 RDB의 특성상 복잡 쿼리를 활용해야하는 경우 

### 영속성 컨텍스트

- 객체와 관계형 데이터베이스 매핑하기 
- 영속성 컨텍스트
  - JPA를 이해하는데 가장 중요한 용어 
  - "엔티티를 영구 저장하는 환경"이라는 뜻 
  - 논리적인 개념
  - 눈에 보이지 않음 
  - Entity Manager를 통해 영속성 컨텍스트에 접근 

###  중요

- 엔티티 매니저 팩토리는 하나만 생성해서 애플리케이션 전체에서 공유
- Entity Manager는 쓰레드 간에 공유 X ( 사용하고 버려야 한다 )
- JPA의 모든 데이터 변경은 트랜잭션 안에서 실행 

### 용어 

- JPA Entity 생명주기 상의 Flush ( https://gmlwjd9405.github.io/2019/08/07/what-is-flush.html )

---

> https://www.inflearn.com/course/ORM-JPA-Basic/lecture/21683?tab=curriculum&volume=1.00&quality=auto
> https://joont92.github.io/db/%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98-%EA%B2%A9%EB%A6%AC-%EC%88%98%EC%A4%80-isolation-level/
> https://effectivesquid.tistory.com/entry/%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4-Isolation-Level

h2 database 설정이 잘 안될 때, 
> https://roadrunner.tistory.com/646
> 
> https://dololak.tistory.com/285
> 
> https://hororolol.tistory.com/373
> 
> https://bluayer.com/23 - 해당 방식으로 해결함. 
> - http://localhost:8082/login.do?jsessionid=f57abf88ef88382b4baa02d0827b298f

spring을 사용하지 않고, JPA만 사용하는 경우 Unkown Entity가 표시될때, 

- https://inf.run/jGHt
```
빌드 환경에 따라서 클래스 인식이 자동으로 안되는 경우도 있습니다.
따라서 이때는 persistence.xml에 다음과 같이 <class></class>로 엔티티를 추가해주세요.
<persistence-unit name="hello">
   <class>hellojpa.Member</class>
   <properties>
그런데 이 부분은 크게 걱정을 안하셔도 되는 것이, 실무에서는 보통 스프링과 함께 JPA를 사용하게 됩니다. 스프링과 함께 사용하면 자동으로 엔티티를 스캔하는 기능이 내장되어 있어서 이런 추가 설정없이 잘 동작합니다.

지금처럼 순수 JPA를 학습할 때만 이렇게 클래스를 추가하는게 빌드 환경에 따라 필요할 수 있습니다
```