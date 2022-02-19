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
  - JPA 성능 최적화 기능 
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
    - 객체에 대해서 저장하는 persist 시점에도 1차 캐시로 등록이 가능하다. 
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
   - 수정된 엔티티 쓰기 지연 SQL 저장도 등록
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
  
- SEQUENCE 전략
  - Commit 이전에 Sequences 에 의해서 미리 할당해둔 값 까지 성능 최적화를 위해서 가져올 수 있게 처리한다. 
  - 미리 값을 올려두는 방식이기 때문에 크게 상관이 없음 

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

### 실전 예제 1 

- 도메인 모델 분석 > 테이블 설계 [연관관계 확인] -> Entity 설계/매핑 
  - Entity 설계시 제약 조건 및 테이블의 정의를 Entity에 정의하여 사용하는 편이 개발자들의 테이블 명세 및 스펙 확인시 좀더 효율적이다. 
  - 매핑정보를 Entity 내에 모두 정의하는 것 - 추천하는 방식 
- 객체를 기반으로한 설계시에 Order에 대한 회원정보를 가져오는 방식은 멤버번호를 통해 재조회하는 것이 아닌 Order가 회원 객체를 가지고 있다가
  전달하는 방식이 좋다.

##### 데이터 중심 설계의 문제점 

- 현재 방식은 객체 설계를 테이블 설계에 맞춘 방식 
- 테이블의 외래키를 객체에 그대로 가져옴
- 객체 그래프 탐색이 불가능
- 참조가 없으므로 UML도 잘못됨. 

### 연관관계 매핑 기초 

- 객체와 테이블 연관관계의 차이를 이해 
- 객체의 참조와 테이블의 외래키를 매핑 
  - 방향 : 단방향, 양방향
  - 다중성 : 다대일, 일대다, 일대일, 다대다
  - 연관관계의 주인 : 객체 양방향 연관관계는 관리 주인이 필요

- 객체 지향 설계의 목표는 객체들의 협력 공동체를 만드는 것이다. 

- 객체를 테이블에 맞추어 모델링 

##### 객체를 테이블에 맞추어 데이터 중심으로 모델링하면, 협력 관계를 만들수 없다. 

- 테이블은 외래키로 조인을 사용해서 연관된 테이블을 찾는다. 
- 객체는 참조를 사용해서 연관된 객체를 찾는다. 
- 테이블과 객체 사이에 이런 큰 간격이 있다. 

```java

public class JPAMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        try{

            Team team = new Team();
            team.setName("Bong Team");
            entityManager.persist(team);

            Member member = new Member();
            member.setUsername("Member 1");
            member.setTeamId(team.getTeamId());
            entityManager.persist(member);

            Member findMember = entityManager.find(Member.class, member.getId());

            Long findTeamId = findMember.getTeamId();
            Team findTeam = entityManager.find(Team.class, findTeamId);

            System.out.println("findTeam.getTeamId() = " + findTeam.getTeamId());
            System.out.println("findTeam.getName() = " + findTeam.getName());

            entityTransaction.commit();
        }catch (Exception exception){
            entityTransaction.rollback();
        }finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}


```

##### 단방향 연관 관계
 
- JPA에서의 객체지향 모델링의 방식은 아래와 같다. 

```java

package bong.lines.jpashoping.step2;

import javax.persistence.*;

@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

```

```java

public class JPAMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        try{

            Team team = new Team();
            team.setName("TEAM A");
            entityManager.persist(team);

            Member member = new Member();
            member.setUsername("Lines Bong");
            member.setTeam(team);

            entityManager.persist(member);

            // 만약 영속성 컨텍스트가 아닌 db에서 쿼리로 조회해오고 싶다면,
            entityManager.flush(); // db에 모든 값 반영 - commit 전에 반영 가능
            entityManager.clear(); // 영속성 컨텍스트 초기화

            Member member1 = entityManager.find(Member.class, member.getId());

            Team team1 = member.getTeam();

            System.out.println("team1.getTeamId() = " + team1.getTeamId());
            System.out.println("team1.getName() = " + team1.getName());

            entityTransaction.commit();
        }catch (Exception exception){
            entityTransaction.rollback();
        }finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}

```

```shell

Hibernate: 
    select
        m1_0.MEMBER_ID,
        t1_0.TEAM_ID,
        t1_0.name,
        m1_0.USERNAME 
    from
        Member as m1_0 
    left outer join
        Team as t1_0 
            on m1_0.TEAM_ID = t1_0.TEAM_ID 
    where
        m1_0.MEMBER_ID = ?
team1.getTeamId() = 1
team1.getName() = TEAM A

```
### 양방향 연관 관계와 연관관계의 주인 

- 양방향 매핑 
  - 양쪽으로 참조해서 값을 가질 수 있을 경우 
    - 객체의 참조와 테이블의 외래키의 차이

- 연관관계의 주인과 mappedBy
  - 객체와 테이블 간에 연관관계를 맺는 차이를 이해한다.
    - 객체 연관관계 2개 
      - 회원 -> 팀 연관관계 1개 ( 단방향 )
      - 팀 -> 회원 연관관계 1개 ( 단방향 )
    - 테이블 연관관계 = 1 개 
      - 회원 <-> 팀의 연관관계 1개 ( 양방향 )

- 객체의 양방향 관계 
  - 객체의 양방향 관계는 사실 양방향 관계가 아니라 서로 다른 단방향 관계 2개다. 
  - 객체를 양방향으로 참조하려면 단방향 연관관계 2개를 만들어야 한다. 

- 테이블의 양방향 관계 
  - 테이블은 외래키 하나로 두 테이블의 연관관계를 관리 
  - MEMBER.TEAM_ID 외래키 하나로 양방향 연관관계 가짐 ( 양쪽으로 조인할 수 있다. )


- 딜레마를 해결하는 방법
  - 딜레마 : Team 객체와 Member 객체에 존재하는 teamId를 어느 곳에서든 업데이트 할 수 있는데.. 어디서 해야하지?
  - Member와 Team의 객체 내에 존재하는 member의 값을 어떻게 관리해야 하는가?
    - 둘 중 하나로 외래키를 관리해야 한다.

- 연관관계의 주인 
  - 양방향 매핑 규칙 
    - 객체의 두 관계 중 하나를 연관관계의 주인으로 지정
    - **연관관계의 주인만이 외래키를 관리 ( 등록, 수정 )**
    - **주인이 아닌 쪽은 읽기만 가능**
    - 주인은 mappedBy 속성 사용 불가 
    - 주인이 아닌면 mappedBy 속성으로 주인 지정
      - mappedBy의 속성의 값에 대해서는 값을 수정하는 것은 변경 불가

- 그렇다면 누구를 주인으로? 
  - **외래키가 있는 곳을 주인으로 정해라** 
    - ManyToOne의 Many가 연관관계의 주인이 되고 
    - N:1의 N이 주인 
  - 여기서는 Member.team이 연관관계의 주인 
    - 진짜 매핑 - 연관관계의 주인 Member.team 
    - 가짜 매핑 - 주인의 반대편 Team.members

- Entity의 기본 정의는 아래와 같이 !

```java
 
@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String username;

    /**
     * 여러 N의 Team에 하나의 Member
     */
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;
}


@Entity
public class Team {

  @Id
  @GeneratedValue
  @Column(name="TEAM_ID")
  private Long teamId;

  private String name;

  @OneToMany(mappedBy = "team")
  private List<Member> members = new ArrayList<>();
}

```

- Insert를 잘못하는 경우 
  - mappedBy 객체는 읽기 전용이기 때문에 값이 저장될 수 없음. 
  - 연관관계의 주인에 값을 입력하지 않음 

```java

public class JPAMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        try{

            Member member = new Member();
            member.setUsername("Lines Bong");
            entityManager.persist(member);

            // Team을 저장하는 방법
            Team team = new Team();
            team.setName("TEAM A");
            team.getMembers().add(member);
            entityManager.persist(team); // 영속 상태가 되면 무조건 pk 값은 생성됨.


            // 만약 영속성 컨텍스트가 아닌 db에서 쿼리로 조회해오고 싶다면,
            entityManager.flush(); // db에 모든 값 반영 - commit 전에 반영 가능
            entityManager.clear(); // 영속성 컨텍스트 초기화


            entityTransaction.commit();
        }catch (Exception exception){
            entityTransaction.rollback();
        }finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}

```

- Insert가 제대로 되는 경우 

```java

public class JPAMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        try{

            // Team을 저장하는 방법
            Team team = new Team();
            team.setName("TEAM A");
            entityManager.persist(team); // 영속 상태가 되면 무조건 pk 값은 생성됨.

            Member member = new Member();
            member.setUsername("Lines Bong");
            member.setTeam(team);
            entityManager.persist(member);

            // 만약 영속성 컨텍스트가 아닌 db에서 쿼리로 조회해오고 싶다면,
            entityManager.flush(); // db에 모든 값 반영 - commit 전에 반영 가능
            entityManager.clear(); // 영속성 컨텍스트 초기화

            entityTransaction.commit();
        }catch (Exception exception){
            entityTransaction.rollback();
        }finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
```

- 양방향 매핑시 연관관계의 주인에 값을 입력해야한다 
  - 순수한 객체 관계를 고려하면 항상 양쪽다 값을 입력해야한다.
  - 이유는 영속성 컨택스트의 개념으로 인하여 만약 entityManager의 flush(), clear()가 실행되지 않는 상태라면, 1차 캐시에 값이 존재하지 않는다. 
    - 왜냐면 mappedBy가 선언된 객체에서 값이 지정되지 않았기 때문에 영속성 컨텍스트가 초기화 되기 전까지 메모리에 값이 없기 때문임 
  - 테스트 코드 작성시 JPA 없이 사용하는 경우, 
    - 코드 상의 이슈 , 에러를 발생시킬 수 있기 때문임. 

```java

public class JPAMain {
  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

    EntityManager entityManager = entityManagerFactory.createEntityManager();

    EntityTransaction entityTransaction = entityManager.getTransaction();

    entityTransaction.begin();

    try {

      // Team을 저장하는 방법
      Team team = new Team();
      team.setName("TEAM A");
      entityManager.persist(team); // 영속 상태가 되면 무조건 pk 값은 생성됨.

      Member member = new Member();
      member.setUsername("Lines Bong");
      member.setTeam(team);

      team.getMembers().add(member);

      entityManager.persist(member);

      // 만약 영속성 컨텍스트가 아닌 db에서 쿼리로 조회해오고 싶다면,
      entityManager.flush(); // db에 모든 값 반영 - commit 전에 반영 가능
      entityManager.clear(); // 영속성 컨텍스트 초기화

      entityTransaction.commit();
    } catch (Exception exception) {
      entityTransaction.rollback();
    } finally {
      entityManager.close();
    }

    entityManagerFactory.close();
  }
}

```

- 순수 객체 상태를 고려해서 항상 양쪽에 값을 설정하자 
- **연관관계 편의 메소드를 생성하자 : changeTeam(Team team) 부분 참고!**
  - 해당 시점에 선언하는 team에 대해서는 getter/setter보다는 명시적으로 함수를 정의하여 사용한다. 
  - lombok 등에 의한 자동화로 setter가 가지는 의미가 중요하지 않을 수 있기 때문에 개념적으로 분리한다. 
  - 연관관계 편의 메서드는 사용에 따라서 Member에 정의하거나, Team에 정의할 수 있는데, 양쪽에 존재하는 경우에는 문제가 있을 수 있음 
    - 따라서 한쪽에 정의하였을 경우에는 다른 한쪽은 제거 

```java

// Member에 연관관계 편의 메서드를 제공하는 경우 

@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Team getTeam() {
        return team;
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}

```

```java

// Team에 연관관계 편의 메서드를 제공하는 경우 

@Entity
@SequenceGenerator(name="team_seq_generator", sequenceName = "team_seq", allocationSize = 1)
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_seq_generator")
    @Column(name="TEAM_ID")
    private Long teamId;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    public void addMember(Member member){
        member.setTeam(this);
        members.add(member);
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
```

- 양방향 매핑시 무한 루프를 조심하자
  - 예) toString(), lombok, JSON 생성 라이브러리
    - toString() 의 무한 루프 사례
  
```java

public class Team {
    @Override
    public String toString(){
        return "Team (" +
                "id=" + id +
                ", name=" + name + '\'' +
                ", members=" + members + 
                ")";
    }
}

```

- Entity를 바로 Controller로 반환하는 경우,
  - 많은 문제가 생길 수 있음. 
    - JSON 생성 라이브러리를 사용하는 경우, 
      - 컨트롤러에는 Entity를 절대 반환하지 말 것! 절때 반환하지 말 것! 
      - Entity를 DTO로 변환하여 반환하라! 

- **양방향 매핑 정리**
  - 단방향 매핑 만으로도 이미 연관관계 매핑은 완료 
  - 양방향 매핑은 반대방향으로 조회 ( 객체 그래프 탐색 ) 기능이 추가된 것 뿐 
  - JPQL에서 역방향 탐색할 일이 많음 
  - 단방향 매핑을 잘하고 양방향 은 필요할 때 추가해도됨. ( 테이블에 영향을 주지 않음 )
- **연관관계의 주인을 정하는 기준**
  - 연관관계의 주인은 외래키의 위치를 기준으로 정리해야함. 
  - 비즈니스 로직을 기준으로 연관관계의 주인을 선택하면 안됨. 

### 다양한 연관계의 매핑 

- 연관관계 매핑시 고려 사항 
  - 다중성 
  - 단방향, 양방향
    - 테이블 
      - 외래키 하나로 양쪽 조인 가능 
      - 사실 방향이라는 개념이 없음 
    - 객체 
      - 참조용 필드가 있는 쪽으로만 참조 가능 
      - 한쪽만 참조하면 단방향
      - 양쪽이 서로 참조하면 양방향 ( 단방향이 2개인 것 - 서로 양쪽의 참조관계가 존재함 )
  - 연관관계의 주인
    - 테이블은 외래키 하나로 두 테이블이 연관관계를 맺음 
    - 객체 양방향 관계는 A->B, B->A 처럼 참조가 2군데 
    - 객체 양방향 관계넌 참조가 2군데 있음, 둘중 테이블의 외래키를 관리할 곳을 지정해야함 
    - 연관관계의 주인: 외래키를 관리하는 참조 
    - 주인의 반대편: 외래키에 영향을 주지 않음. 

##### 다대일 ( N : 1 ) @ManyToOne

- 가장 많이 사용하는 연관관계
  - @ManyToOne을 사용한 객체를 기준으로 Primary Key를 가지는 테이블에 대해서 @OneToMany로 데이터를 가져올 수 있다. 
    - MEMBER와 TEAM의 관계 

##### 일대다 ( 1 : N ) @OneToMany 

- 일대다 단방향은 일대다(1:N)에서 일(1)이 연관관계의 주인 
- 테이블 일대다 관계는 항상 다(N) 쪽에 외래키가 있음 
- 객체와 테이블의 차이 때문에 반대편 테이블의 외래키를 관리하는 특이한 구조 
- @JoinColumn을 꼭 사용해야함. 그렇지 않으면 조인 테이블 방식을 사용함 ( 중간에 테이블을 하나 추가함 )
  - 테이블이 신규로 하나더 추가되기 때문에 성능상, 운영상 좋은 방식은 아님 ( 조인 테이블 )

```java
@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

```

```java
@Entity
@SequenceGenerator(name="team_seq_generator", sequenceName = "team_seq", allocationSize = 1)
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_seq_generator")
    @Column(name="TEAM_ID")
    private Long teamId;

    private String name;

    @OneToMany
    @JoinColumn(name = "TEAM_ID")
    private List<Member> members = new ArrayList<>();

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
```

- 1:N - OneToMany 연관관계 코드 

```java

public class JPAMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        try{

            Member member = new Member();
            member.setUsername("bong1");

            entityManager.persist(member);

            Team team = new Team();

            team.setName("Bong Team");
            team.getMembers().add(member);

            entityManager.persist(team);

            entityTransaction.commit();
        }catch (Exception exception){
            entityTransaction.rollback();
        }finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}

```

- 실행 결과 

```shell
Hibernate: 
    /* insert bong.lines.jpashoping.onetomany.Member
        */ insert 
        into
            Member
            (USERNAME, MEMBER_ID) 
        values
            (?, ?)
Hibernate: 
    /* insert bong.lines.jpashoping.onetomany.Team
        */ insert 
        into
            Team
            (name, TEAM_ID) 
         values
            (?, ?)
Hibernate: 
    /* create one-to-many row bong.lines.jpashoping.onetomany.Team.members */ update
        Member 
    set
        TEAM_ID=? 
    where
        MEMBER_ID=?
```

- 일대다 연관관계를 잘 사용하지 않는 이유 
  - 자바 코드 상에서 로직과 테이블의 연관관계 상 혼란이 올 수 있음 
  - 테이블이 수십개가 돌아가는 운영 기준에서는 혼란이 올 수 있음 
  - 엔티티가 관리하는 외래키가 다른 테이블에 있음 
  - 연관 관계 관리를 위해서 추가로 UPDATE SQL 실행 
- **일대다 단방향보다는 다대일 양방향 매핑을 사용하자** 


- 일대다 양방향 정리
  - 이런 매핑은 공식적으로 X
  - @JoinColumn(insertable=false, updatable=false)
  - 읽기 전용 필드를 사용해서 양방향 처럼 사용하는 방법 
  - **다대일 양방향을 사용하자** 

```java

@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String username;

    // 해당 코드는 읽기 전용이 됨. Insert, Update는 동작하지 않음 - 일대다 양방향 관계 
    @ManyToOne
    @JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

```

##### 일대일 ( 1 : 1 ) @OneToOne

- 일대일 관계는 그 반대도 일대일 
- 주 테이블이나 대상 테이블 중에 외래키 선택 가능 
  - 주 테이블에 외래키 
    - 다대일 단뱡향 매핑과 유사함. 
    - 객체 지향 개발자 선호
    - JPA 매핑 정리 
    - 장점 : 주테이블만 조회해도 대상 테이블에 데이터가 있는지 확인 가능 
    - 단점 : 값이 없으면 외래키에 NULL 허용
  - 대상 테이블에 외래키 
    - 대상 테이블에 외래키가 존재 
    - 전통적인 데이터 베이스 개발자 선호 
    - 장점 : 주테이블과 대상 테이블을 일대일에서 일대다 돤계로 변경할 때 테이블 구조 유지 
    - 단점 : 프록시 기능의 한계로 지연로딩으로 설정해도 항상 즉시 로딩됨 
- 외래키에 데이터베이스 유니크 제약 조건 추가 
- 다대일 양방향 매핑 처럼 외래키가 있는 곳이 연관관계의 주인 
- 반대편은 mappedBy 적용 

```java
@Entity
public class Locker {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(mappedBy = "locker")
    private Member member;
}
```

```java
@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String username;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
```

##### 다대다 ( N : M) @ManyToMany

- 실무에서는 사용하면 안됨 
  - 관계형 데이터베이스는 정규화된 테이블 2개로 다대다 관계를 표현할 수 없음 
  - 연결 테이블을 추가해서 일대다, 다대일 관계로 풀어내야함. 
  - 객체는 컬렉션을 사용해서 객체 2개로 다대다 관계 가능 
    - 테이블에서는 Join Table을 이용해서 관계를 구성이 가능함. 

- 편리해보이지만 실무에서 사용 안함
- 연결 테이블이 연결만 하고 끝나지 않음 
- 주문 시간, 수량 같은 데이터가 들어올 수 있음]

```java

@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String username;

    @ManyToMany
    @JoinTable(name = "MEMBER_PRODUCT")
    private List<Product> products = new ArrayList<>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

```

```java

@Entity
public class Product {

    @Id @GeneratedValue
    private Long id;


    @ManyToMany(mappedBy = "products")
    List<Member> members = new ArrayList<>();

}

```

```shell

Hibernate: 
    
    create table Member (
       MEMBER_ID bigint not null,
        USERNAME varchar(255),
        TEAM_ID bigint,
        primary key (MEMBER_ID)
    )
Hibernate: 
    
    create table MEMBER_PRODUCT (
       members_MEMBER_ID bigint not null,
        products_id bigint not null
    )
Hibernate: 
    
    create table Product (
       id bigint not null,
        primary key (id)
    )
Hibernate: 
    
    create table Team (
       TEAM_ID bigint not null,
        name varchar(255),
        primary key (TEAM_ID)
    )
Hibernate: 
    
    alter table if exists Member 
       add constraint FKl7wsny760hjy6x19kqnduasbm 
       foreign key (TEAM_ID) 
       references Team
Hibernate: 
    
    alter table if exists MEMBER_PRODUCT 
       add constraint FKc6hsxwm11n18ahnh5yvbj62cf 
       foreign key (products_id) 
       references Product
Hibernate: 
    
    alter table if exists MEMBER_PRODUCT 
       add constraint FKp9hlrsu8hrsusdymar0ddcl9o 
       foreign key (members_MEMBER_ID) 
       references Member


```

- 다대다 한계 극복
  - @ManyToMany -> @OneToMany, @ManyToOne
  - 중간 테이블(JoinTable)을 중간 Entity로 승격 처리( 연결 테이블을 엔티티 승격 )

```java

@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String username;

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

```

```java

@Entity
public class MemberProduct {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name= "PRODUCT_ID")
    private Product product;

}

```

```java

@Entity
public class Product {

    @Id @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "product")
    List<MemberProduct> memberProducts = new ArrayList<>();

}

```

### 연관관계 정리 하기 

```java

@Entity
public class Member {
    @Id
    @Column(name="MEMBER_ID")
    @GeneratedValue
    private Long id;

    private String name;

    private String city;

    private String street;

    private String zipcode;

    private String orders;
}

@Entity
@Table(name = "ORDERS")
public class Order {

  @Id
  @Column(name = "ORDER_ID")
  @GeneratedValue
  private String id;

  @ManyToOne
  @JoinColumn(name = "MEMBER_ID")
  private Member member;

  @OneToOne
  @JoinColumn(name="DELIVERY_ID")
  private Delivery delivery;

  @OneToMany(mappedBy = "order")
  private List<OrderItem> orderItems = new ArrayList<>();

  private LocalDate orderDate;

  private OrderStatus orderStatus;

}

@Entity
public class OrderItem {

  @Id
  @Column(name="ORDER_ITEM_ID")
  @GeneratedValue
  private Long id;

  @ManyToOne
  @JoinColumn(name="ORDER_ID")
  private Order order;

  private int orderPrice;

  private int count;
}


@Entity
public class Delivery {

  @Id
  @Column(name = "DELIVERY_ID")
  @GeneratedValue
  private String id;

  @OneToOne(mappedBy = "delivery")
  private Order order;

  private String city;

  private String street;

  private String zipcode;

  private DeliveryStatus deliveryStatus;
}

@Entity
public class Item {

  @Id
  @Column(name = "ITEM_ID")
  @GeneratedValue
  private Long id;

  private String name;

  private int price;

  private int stockQuantity;

  @ManyToMany(mappedBy = "items")
  private List<Category> categories = new ArrayList<>();
}


@Entity
public class Category {

  @Id
  @GeneratedValue
  @Column(name = "CATEGORY_ID")
  private Long id;

  @ManyToMany
  @JoinTable(name = "CATEGORY_ITEM", joinColumns = @JoinColumn(name = "CATEGORY_ID"), inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
  private List<Item> items = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "PARENT_IO")
  private Category parent;

  @OneToMany(mappedBy = "parent")
  private List<Category> child;
}

```

- @JoinColumn 
  - name : 매핑할 외래키 이름 
  - referencedColumnName : 외래키가 참조하는 대상 테이블의 컬럼명
  - foreignKey(DDL) : 외래키 제약 조건은 직접 지정할 수 잇다. 이 속성은 테이블 생성시만 사용 가능 
  - unique, nullable, insertable, updatable, columnDefinition, table : @Column 속성과 같음. 

- @ManyToOne - 연관관계의 주인이 되어야함. 
  - optional : false로 설정하면 연관된 엔티티가 항상 있어야 한다. 
  - fetch : 글로벌 패치 전략을 설정한다. 
    - @ManyToOne : FetchType.EAGER
    - @OneToMany : FetchType.LAZY
  - cascade : 영속성 전이 기능을 사용한다. 
  - targetEntity : 연관된 엔티티의 타입 정보를 설정한다. 이기능은 거의 사용하지 않는다. 컬렉션을 사용해도 제네릭으로 타입정보를 알 수 있다.

- @OneToMany 
  - mappedBy : 연관관계의 주인을 선택한다. 
  - fetch 
  - cascade
  - targetEntity

### 상속관계 매핑 

- 관계형 데이터 베이스는 상속 관계 없음
- 슈퍼타입, 서브타입 관계라는 모델링 기법이 객체 상속과 유사 
- 상속 관계 매핑 : 객체의 상속과 구조와 DB의 서브 타입, 슈퍼타입 관계를 매핑하는 것 
  - 슈퍼 타입 서브타입 논리 모델을 실제 물리 모델로 구현하는 방법 
    - 각각 테이블로 변환 -> 조인 전략
    - 통합 테이블로 전환 -> 단일 테이블 전략
    - 서브 타입 테이블로 전환 -> 구현 클래스마다 테이블 전략 

- 주요어노테이션 
  - @Inheritance(strategy=InheritanceType.XXX)
    - JOINED : 조인 전략
    - SINGLE_TABLE : 단일 테이블 전략 
    - TABLE_PER_CLASS : 구현 클래스마다 테이블 전략 
  - @DiscriminatorColumn(name="DTYPE")
  - @DiscriminatorValue("XXX") 

- Entity를 상속 받은 후 , 별도의 설정이 없을 경우 SINGLE_TABLE 전략이 적용됨. - 한 테이블에 모든 컬럼이 정의됨.

```java

@Entity
public class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;
}

@Entity
public class Album extends Item{

  private String artist;

}

@Entity
public class Book extends Item {

  private String author;
  private String itbn;
}

@Entity
public class Movie extends Item {

  private String director;
  private String actor;
}

```

```shell

Hibernate: create sequence Item_SEQ start with 1 increment by 50
Hibernate: 
    
    create table Item (
       DTYPE varchar(31) not null,
        id bigint not null,
        name varchar(255),
        price integer not null,
        artist varchar(255),
        author varchar(255),
        itbn varchar(255),
        actor varchar(255),
        director varchar(255),
        primary key (id)
    )

```

- @Inheritance(strategy = InheritanceType.JOINED) 적용시 
  - 우리가 정의한 설계 모델에 따라서 테이블이 생성됨. 

```java

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;
}

```

```shell

create table Album (
       artist varchar(255),
        id bigint not null,
        primary key (id)
    )
Hibernate: 
    
    create table Book (
       author varchar(255),
        itbn varchar(255),
        id bigint not null,
        primary key (id)
    )
Hibernate: 
    
    create table Item (
       id bigint not null,
        name varchar(255),
        price integer not null,
        primary key (id)
    )
Hibernate: 
    
    create table Movie (
       actor varchar(255),
        director varchar(255),
        id bigint not null,
        primary key (id)
    )
Hibernate: 
    
    alter table if exists Album 
       add constraint FKcve1ph6vw9ihye8rbk26h5jm9 
       foreign key (id) 
       references Item
Hibernate: 
    
    alter table if exists Book 
       add constraint FKbwwc3a7ch631uyv1b5o9tvysi 
       foreign key (id) 
       references Item
Hibernate: 
    
    alter table if exists Movie 
       add constraint FK5sq6d5agrc34ithpdfs0umo9g 
       foreign key (id) 
       references Item

```

- JOINED 전략에 의한 Insert 시 

```shell

Hibernate: 
    /* insert bong.lines.jpashoping.inheritance.Movie*/ 
    insert 
        into
    Item (name, price, id) 
    values
        (?, ?, ?)


    /* insert bong.lines.jpashoping.inheritance.Movie*/ 
    insert
        into
    Movie
        (actor, director, id)
    values
        (?, ?, ?)

```

- JOIN 전략에 의해서 구성된 테이블 조회시 

```shell

select
        m1_0.id,
        m1_1.name,
        m1_1.price,
        m1_0.actor,
        m1_0.director 
  from
        Movie as m1_0 
  inner join
        Item as m1_1 
            on m1_0.id = m1_1.id 
  where
        m1_0.id = ?

```

- @DiscriminatorColumn 
  - DTYPE이 생기고 기본이 Entity 명이 들어가게됨. 실질적으로 어떤 값을 통해서 들어오게 된 것인지에 대한 인지가 가능하다. 
  - 운영상 DTYPE은 반드시 필요함
  - SINGLE_TABLE일 경우, 선언하지 않아도 자동 세팅됨. 
  - properties
    - name : 컬럼명 변경도 가능함. 

```java


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public abstract class Item {
    
    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;
}


```

```shell
  create table Item (
     DTYPE varchar(31) not null,
      id bigint not null,
      name varchar(255),
      price integer not null,
      primary key (id)
  )
```

- @DiscriminatorValue("A")
  - 부모클래스에 값이 들어갈 때, 자식 클래스에 해당 Annotations에 정의되어 있는 값으로 넣어줄 수 있음 

```java

@Entity
@DiscriminatorValue("A")
public class Album extends Item{

    private String artist;

}


```

- SINGLE_TABLE 전략
  - 상속관계의 객체에 대해서 하나의 테이블에도 모두 구성할 경우 
    - @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
    - 성능이 잘 나올 수 있음 , 조인 불필요 
    - 단일 테이블 전략에서는 DiscriminatorColumn 이 선언되지 않아도 DTYPE이 필수로 생성됨. 
    

```shell
   create table Item (
       DTYPE varchar(31) not null,
        id bigint not null,
        name varchar(255),
        price integer not null,
        artist varchar(255),
        author varchar(255),
        itbn varchar(255),
        actor varchar(255),
        director varchar(255),
        primary key (id)
    )
```

- 구현 클래스마다 테이블 전략
  - 상속관계의 객체 구조를 제거함. 
  - @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
  - @DiscriminatorColumn이 적용되지 않음 
    - 테이블 마다 생성되기 때문에 DTYPE을 이용한 구분이 불필요함. 
  - 해당 전략은 
    - Item 객체의 값을 가져오고 싶을 경우, 하위테이블을 모두 union all을 적용해서 전체 조회해야함. 
    - 성능상의 이슈가 발생할 수 있음. 

```java


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Item {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;
}


```

```shell

Hibernate: 
    
    create table Album (
       id bigint not null,
        name varchar(255),
        price integer not null,
        artist varchar(255),
        primary key (id)
    )
Hibernate: 
    
    create table Book (
       id bigint not null,
        name varchar(255),
        price integer not null,
        author varchar(255),
        itbn varchar(255),
        primary key (id)
    )
Hibernate: 
    
    create table Movie (
       id bigint not null,
        name varchar(255),
        price integer not null,
        actor varchar(255),
        director varchar(255),
        primary key (id)
    )

```

- 장단점
  - JOIN 전략 :  
    - 장점 : 정규화 되어 있음, 외래키 참조 무결성 제약조건 사용 가능, 저장 공간 효율화
      - 기본적인 전략으로 사용해야함.
    - 단점 : 조회시 조인을 많이 사용됨, 조회 쿼리가 복잡함, 데이터 저장시 INSERT SQL 2번 호출 
  - SINGLE TABLE 전략 : 
    - 장점 : 조인이 필요 없으므로 성능이 빠름, 조회쿼리가 단순함. 
    - 단점 : 자식 엔티티가 매핑항 컬럼은 모두 null 허용 해야함. 
    - 단점 : 단일 테이블에 모든 것을 저장하므로 테이블이 커질 수 있으므로 상황에 따라서 조회 성능이 오히려 느려질 수 있다.
  - 구현클래스마다 테이블 전략 
    - 사용하지 말 것 
    - 이전략은 데이터베이스 전문가와 설계자가 좋아하지 않은 전략 ! 
    - 장점 : 서브 타입을 명확하게 구분해서 처리할 때 효과적, not null 제약조건 사용 가능 
    - 단점 : 여러 자식 테이블을 함께 조회할 때 성능이 느림, 자식 테이블을 통합해서 쿼리하기 어려움.



###  중요

- 연관관계를 잘 끊어내는 것이 중요함
  - 할 수 있다면 가급적 단방향에 의한 연관관계 매핑을 사용하고, 실무에서 필요한 경우 양방향 연관관계 매핑을 사용하라! 
- 가급적으로는 단방향 매핑이 좋음 
- 엔티티 매니저 팩토리는 하나만 생성해서 애플리케이션 전체에서 공유
- Entity Manager는 쓰레드 간에 공유 X ( 사용하고 버려야 한다 )
- JPA의 모든 데이터 변경은 트랜잭션 안에서 실행
- 다대다의 관계는 실무에서 사용하며 안됨

### 용어 / 참조 

- JPA Entity 생명주기 상의 Flush ( https://gmlwjd9405.github.io/2019/08/07/what-is-flush.html )

---

> 참고 정리 - https://www.inflearn.com/course/ORM-JPA-Basic/lecture/21683?tab=curriculum&volume=1.00&quality=auto
> https://joont92.github.io/db/%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98-%EA%B2%A9%EB%A6%AC-%EC%88%98%EC%A4%80-isolation-level/
> https://effectivesquid.tistory.com/entry/%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4-Isolation-Level

> 참고 문서 - [Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference) 

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
