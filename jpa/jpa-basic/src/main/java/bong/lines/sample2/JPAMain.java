package bong.lines.sample2;

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
            member.setUserName("Bongs1111");
            entityManager.persist(member);
            Member member1 = entityManager.find(Member.class, 8L);
            //Member member2 = entityManager.find(Member.class, 8L);

        }catch (Exception exception){
            exception.printStackTrace();
            entityTransaction.rollback();
        }finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
