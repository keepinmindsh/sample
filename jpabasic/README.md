
### identity ERROR: NULL not allowed for column "ID"; SQL statement:

- [JPA Insert SQL with IDENTITY](https://www.inflearn.com/questions/374987)

### 2022-03-28 

 - [Persistence](https://thorben-janssen.com/jpa-persistence-xml/)
 - 본인의 Class 하위에 모든 Class 를 정의해서 사용하는 경우 
   - [Entity Manage - Configuration - persistence.xml](https://docs.jboss.org/hibernate/stable/entitymanager/reference/en/html/configuration.html)

### 2022-03-25 - TODO 해결 - 해당 부분에서 영속 계층으로 등록되었는데 왜? 인식이 안되나! 확인필요!!
 - https://findanyanswer.com/how-do-you-persist-a-detached-object-in-hibernate
 - https://javabydeveloper.com/merge-re-attaching-detached-entities/

```java
class Sample {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("wings-persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try{
            Member member = entityManager.find(Member.class, 52L);
            
            entityManager.detach(member);
            
            Member remerged_member = entityManager.merge(member);

            remerged_member.setUsername("HoHo!!!");

            entityManager.persist(remerged_member);

            entityTransaction.commit();
        }catch (Exception exception){
            System.err.println(exception.getLocalizedMessage());
            entityTransaction.rollback();
        }finally {
            System.out.println("처리완료");
            entityManager.close();
        }
        entityManagerFactory.close();
    }
}
```

### 프로젝트 과제 2022-03-28 
 - Proxy Pattern 세팅 해오기 

### 

 - TB_IR_RSVN_MST
   - RSVN_NO  ( PK )
 
  RSVN_NO : 1101
 
 - TB_IR_RSVN_DTL
   - RSVN_NO  ( PK, FK)
   - RSVN_SEQ_NO ( PK )
     ( RSVN_NO, RSVN_SEQ_NO )

  RSVN_NO : 1101 , 1  - 저장할 때...
  

MST : DTL =  1 : N


MST : DTL = N : N

MST : N

MST_DTL : 1 : 1

DTL : N