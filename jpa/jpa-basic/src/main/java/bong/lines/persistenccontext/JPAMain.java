package bong.lines.persistenccontext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JPAMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        try{

            Member member = new Member();
            member.setUserName("SHJeong");

            entityManager.persist(member);

            // Entity Manager 의 변경사항 적용
            entityManager.flush();
            // 1차 캐쉬 초기화
            entityManager.clear();

            Member member1 = entityManager.find(Member.class, 1L);

            Member member2 = entityManager.find(Member.class, 1L);

            System.out.println("member1 = " + member1);
            System.out.println("member2 = " + member2);

            entityTransaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
            entityTransaction.rollback();
        }finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
