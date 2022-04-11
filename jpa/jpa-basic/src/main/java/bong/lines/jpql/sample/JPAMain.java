package bong.lines.jpql.sample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JPAMain {
    // TODO 샘플 코드 작성을 위한 코드 고도화 필요
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        try{

            Member member = new Member();

            member.setUserName("Seung Hwa");
            member.setId(1L);

            entityManager.persist(member);

            entityManager.flush();
            entityManager.close();

            List<Member> result = entityManager.createQuery(
                    "select m from Member m where m.userName like '%kim%'"
            ).getResultList();



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
