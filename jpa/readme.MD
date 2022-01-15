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
  - 1차 캐시 
    - Entity 조회 , 1차 캐시 
    - 객체를 조회할 때, 영속성 컨텍스트에서 1차 캐시를 질의하여 데이터가 존재한다면 캐시에 있는 값을 그대로 조회함
    - 하나의 Transaction 안에서만 동작하기 때문에 효율성의 이점이 크지 않음. 다만 비즈니스 로직이 복잡할 경우는 도움이 될 수 있음 
    - 객체에 대해서 저장하는 persist 시점에도 1 캐시로 등록이 가능하다. 
  - 동일성 보장 
    - 1차 캐시로 반복 가능한 읽기(REPEATABLE READ) 등급의 트랜잭션 격리 수준을 데이터 베이스가 아닌 애플리케이션 차원에서 제공
  - 트랜잭션을 지원하는 쓰기 지연
    - persist 시점에 데이터를 DB Insert 처리하지 않고 Commit 시점에 처리된다. 
    - persist를 다수 호출 후에 commit 명령어에 의해서 실행되므로, jdbc batch insert 와 동일하게 동작한다. 
      - bufferning을 모아서 적용 가능 
  - 변경 감지 ( Dirty Checking )
    - 영속 컨텍스트에 의해서 Transaction Commit (flush) 시점에 entity와 snapshot를 비교하는데, 
      entity와 snapshot을 비교하여 변경된 값에 대해서 update query를 생성하여 commit 시점에 database에 반영된다. 
  - 지연 로딩 

##### 플러쉬 ( Flush )

 - 영속성 컨텍스트의 변경 내용을 데이터베이스에 반영
   - 변경 감지 
   - 수정된 엔티티 쓰기 지연 SQL 저장도에 등록
   - 쓰기 지연 SQL 저장소의 쿼리를 데이터베이스에 전송 ( 등록, 수정, 삭제 쿼리 )
   - 영속성 컨텍스트를 비우지 않음
   - 영속성 컨텍스트의 변경내용을 데이터베이스에 동기화 
   - 트랜잭션이라는 작업 단위가 중요 -> 커밋 직전에만 동기화 하면됨. 

 - 사용 방법
   - em.flush
   - 트랜잭션 커밋
   - JPQL 쿼리 실행시
   
 - FlushMode 옵션
   - FlushModeType.AUTO : 커밋이나 쿼리를 실행할 때 플러시 ( 기본값 )
   - FlushModeType.COMMIT : 커밋할 때만 플러시 


##### 준영속 상태 

 - 영속 -> 준영속
 - 영속 상태의 엔티티가 영속성 컨텍스트에서 분리 ( detached )
 - 영속성 컨텍스트가 제공하는 기능을 사용하지 못함. 
 - 준영속 상태로 변경하는 방법
   - em.clear - 특정 엔티티만 준 영속 상태로 변환
   - em.detach(Object) - 영속성 컨텍스트를 완전히 초기화 
   - em.close - 영속성 컨텍스트를 종료

##### 비영속 상태 

```java
class Sample {

  public static void main(String[] args) {
    // 객체가 생성된 비영속 상태 
    Member member = new Member();
    member.setId(2L);
    member.setName("Hello");
  }
}
```

##### 준영속, 삭제 

```java

class Sample {
  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

    EntityManager entityManager = entityManagerFactory.createEntityManager();

    // 영속성 컨텍스트에서 분리, 준영속 상태 
    entityManager.detach(member);
    
    // 객체를 삭제한 상태 ( 삭제 ) 
    entityManager.remove(member);
  }
}

```

##### 영속 상태 

```java
class Sample {

  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

    EntityManager entityManager = entityManagerFactory.createEntityManager();

    EntityTransaction entityTransaction = entityManager.getTransaction();

    entityTransaction.begin();


    try {
      
      Member member = new Member();
      member.setId(2L);
      member.setName("Hello");
      
      // 객체를 저장하는 영속 상태 
      entityManager.persist(member);
    }catch (Exception exception){
        
    }
  }
}
```

### 엔티티 매핑 

- @Entity, @Table 
  - @Entity 가 붙은 클래스는 JPA가 관리
  - 기본 생성자 필요 
    - 속성 
      - name : 매핑할 테이블 이름 지정 
      - catalog : 데이터 베이스 catalog 매핑
      - schema : 데이터 베이스 schema 매핑
      - uniqueConstraints : DDL 생성 시에 유니크 제약 조건 생성 
- @Column
- @Id
- @ManyToOne, @JoinColumn 

### 데이터베이스 스키마 자동 생성 

- DLL을 애플리케이션 실행 시점에 자동 생성 
- 테이블 중심 -> 객체 중심 
- 데이터 베이스 방언을 활용해서 데이터베이스에 맞는 적절한 DDL, DML 생성 
  - 데이터베이스 방언별로 달라지는 것 확인 필요 
- 이렇게 생성된 DDL은 개발장비에서만 사용 
- hibernate.hbm2ddl.auto
  - create : 기존 테이블 삭제후 다시 생성 ( drop 하고 create가 됨 )
  - create-drop : create와 같으나 종료 시점에 테이블 DROP
  - update : 변경 분만 반영 ( 운영 db에서 절대 사용하면 안됨 )
  - validate : 엔티티와 테이블이 정상 매핑되었는지만 확인 - 확인 용도 
  - none : 사용하지 않음 
- DDL 생성 기능 
  - 제약조건 추가 
    - @Column(nullable = false, name= "", unique = true, length = 10 )
      - DDL 생성을 도와주는 기능을 제공함. 실행 로직에는 영향을 주지 않음 

hibernate.hbm2ddl.auto=create 일 때, @Column(nullable = false, length = 500, unique = false) 는 아래와 같이 동작함. 

```shell

Hibernate: 
    
    drop table if exists MBR cascade 
Hibernate: 
    
    create table MBR (
       id bigint not null,
        name varchar(500) not null,
        primary key (id)
    )

```

- 주의
  - 운영 장비에는 절대 create, create-drp, update 사용하면안된다.
  - 개발 초기 단계는 create 또는 update
  - 테스트 서버는 update 또는 validate
  - 스테이징과 운영 서버는 validate or none
  
### Mapping Annotations

- @Column  - 컬럼 매핑
  - name
  - insertable : 등록 여부 
  - updatable  : 변경 여부 
  - nullable   : null 값의 허용 여부 설정 
  - unique     : @Table의 uniqueConstraint와 같이만 한 컬럼에 간단히 유니크 제약조건을 걸 때 사용한다. 
    - 잘 사용하지 않는 값 - unique 인덱스 생성시 , 유니크 제약조건을 이름이 반영이 어려워 @Table 에 같이 선언하여 사용한다. 
    - @Table(uniqueConstraint=~~~)
  - columnDefinition
    - 컬럼 정의를 직접하고 싶은 경우, 
  - length
    - 문자길이 제약 조건, String 타입에 사용한다. 
  - precision
    - BigDecimal 타입에서 사용한다. 아주 큰 숫자나 소수점 사용할 경우 
- @Temporal - 날짜 타입 매핑
  - DATE : 날짜, 데이터 베이스 date 타입과 매핑 ( 2021-01-12 )
  - TIME : 시간, 데이터 베이스 time 타입과 매핑 ( 11:11:11 )
  - TIMESTAMP : 날짜와 시간, 데이터베이스 timestamp 타입과 매핑 ( 2021-01-12 11:11:11 ) 
  - 최근에는 ~ LocalDate(년월)와 LocalDateTime ( 년월일) - 최신 버전의 경우 변수 선언서 데이터 타입을 LocalDate와 LocalDateTime를 적용하는 경우
    그에 맞게 호출됨. 아래의 test1과 test2를 참고할 것 
  
```java

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
//@Table(name = "MBR")
public class Member {
    @Id
    private Long id;

    @Column(nullable = false, length = 500, unique = false, name = "name")
    private String name;

    private Integer age;
    
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDAte;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate test1;
    private LocalDateTime test2;
    
    @Lob
    private String description;

    public Member() {
    }
}

```

```shell

    create table Member (
       id bigint not null,
        age integer,
        createDAte timestamp(6),
        description clob,
        lastModifiedDate timestamp(6),
        name varchar(500) not null,
        roleType varchar(255),
        test1 date,
        test2 timestamp(6),
        primary key (id)
    )


```

- @Enumerated - Enum Type 활용
  - 기본값 : ORDINAL - Enum의 순서를 저장하는 것 
    - 쓰면 문제가 되는 이유는, enum에 값을 정의할 때, 내부에서 정해지는 enum의 index 값에 따라 순번이 변경되어 이슈가 발생할 수 있음
    - 운영상에서는 ORDINAL를 사용하지 않음 
    - 반드시 String으로 EnumType을 사용할 것 
- @Lob - Clob, Blob
  - @Lob에는 지정할 수 있는 속성이 없다. 
  - 매핑하는 필드 타입이 문자면 CLOB 매핑, 나머지는 BLOB 매핑
    - CLOB : String, char[], java.sql.CLOB
    - BLOB : byte[], java.sql.BLOB
- @Transient - 매핑을 안하고 싶을 경우

### 기본키 매핑 

- 직접 할당 : @Id만 사용 
- 자동 생성 : @GeneratedValue
  
- IDENTITY
  - 기본키 생성을 데이터 베이스에 위임 
  - 주로 MySQL, PostgreSQL, SQL Server, DB2 에서 사용 
  - JPA는 보통 트랜잭션 커밋 시점에 INSERT SQL 실행 
  - AUTO_INCREMENT는 데이터베이스에 INSERT SQL을 실행한 이후에 ID 값을 알 수 있음
  - IDENTITY 전략은 em.persist() 시점에 즉시 INSERT_SQL 실행하고 DB에서 식별자 조회 

```java

@Entity
@SequenceGenerator(name="member_seq_generator", sequenceName = "member_seq", allocationSize = 1)
public class MemberForSeq {
    
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "member_seq_generator")
  private Long id;

}

```

  - SEQUENCE 
    - 데이터 베이스 시퀀스는 유일한 값을 순서대로 생성하는 특별한 데이터 베이스 오브젝트 ( 예 : 오라클 시퀀스 )
    - 오라클, PostgreSQL, DB2, H2 데이터베이스에서 사용 
    - SEQUENCE에서 타입을 정의할 때, Long을 사용해야는 이유는 10억이 넘어가는 경우 Long으로 변경하는 것이 힘들기 때문에 Long을 사용하는 것이 나음

```java

@Entity
@SequenceGenerator(name="member_seq_generator", sequenceName = "member_seq", allocationSize = 1)
public class MemberForSeq {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
  private Long id;

}

```

  - TABLE 
    - 키 생성 전용 테이블을 하나 만들어서 데이터베이스 시퀀스를 흉내내는 전략
      - name : 식별자 생성기 이름 
      - table : 키 생성 테이블 명 
      - pkColumnName : 시퀀스 컬럼명
      - valueColumnName : 시퀀스 값 컬럼명
      - pkColumnValue : 키로 사용할 값 이름 
      - initialValue : 초기값, 마지막으로 생성된 값이 기준이다. 
      - allocationSize : 시퀀스 한번 호출에 증가하는 수(성능 최적화에 사용됨)
      - catalog, schema : 데이터베이스 catalog, schema 이름 
      - uniqueConstraint : 유니크 제약 조건을 지정할 수 있다. 
    - 장점 : 모든 데이터베이스에 적용 가능 
    - 단점 : 성능

```java

@Entity
@TableGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        table = "MY_SEQUENCE",
        pkColumnValue = "MEMBER_SEQ",
        allocationSize = 1
)
public class MemberForSeq {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "member_seq_generator")
  private Long id;

}

```

- Sequence 생성 : @SequenceGenerator
  - name : 식별자 생성기 이름 
  - sequenceName : 데이터베이스에 등록되어 있는 시퀀스 이름 
  - initialValue : DDL 생성 시에만 사용됨, 시퀀스 DDL을 생성할 때 처음 1 시작하는 수를 지정한다. 
  - allocationSize : 시퀀스 한 번 호출에 증가하는 수(성능 최적화에 사용됨). 데이터베이스 시퀀스 값이 하나씩 증가하도록 설정되어 있으면 이 
    값을 반드시 1로 설정해야한다. ! 주의 - 기본값 : 50
  - catalog, schema : 데이터베이스 catalog, schema 이름 

```java

@Entity
@SequenceGenerator(name="member_seq_generator", sequenceName = "member_seq", allocationSize = 1)
public class MemberForSeq {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
  private Long id;


}

```

- 권장하는 식별자 전략
  - 키본키 제약 조건 : null 아님, 유일, 변하면 안된다. 
  - 미래까지 이 조건을 만족하는 자연키를 찾기 어렵다. 대리키를 사용하자. 
  - 예를 들어 주민등록번호도 기본 키로 적절하지 않다. 
  - 권장 : Long 형 + 대체키 + 키 생성 전략 사용  
    

- IDENTITY 전략 
  - 기본키 생성을 데이터베이스에 위임
    - 영속성 컨텍스트를 위해서 PK 값이 있어야 아는데, PK 값을 알 수 있는 시기가 Commit 이후임.
  - 주로 MySQL, PostgreSQL, SQL Server, DB2에서 사용 ( 예: MySQL의 AUTO_INCREMENT )
  - JPA 는 보통 트랜잭션 커밋 시점에 INSERT SQL 실행 
  - AUTO_INCREMENT 는 데이터베이스에 INSERT_SQL을 실행한 이후에 ID 값을 알 수 있음 
  - IDENTITY 전략은 em.persist() 시점에 즉시 INSERT_SQL 실행하고 DB에서 식별자 조회 
    - identity 전략은 persist() 시점에 insert 값을 처리하고 pk 값을 확인할 수 있다. 

###  중요

- 엔티티 매니저 팩토리는 하나만 생성해서 애플리케이션 전체에서 공유
- Entity Manager는 쓰레드 간에 공유 X ( 사용하고 버려야 한다 )
- JPA의 모든 데이터 변경은 트랜잭션 안에서 실행 

### 용어 

- JPA Entity 생명주기 상의 Flush ( https://gmlwjd9405.github.io/2019/08/07/what-is-flush.html )

---

> 참고 정리 - https://www.inflearn.com/course/ORM-JPA-Basic/lecture/21683?tab=curriculum&volume=1.00&quality=auto
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