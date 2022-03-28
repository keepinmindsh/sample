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
