package bong.lines.sample;

import bong.lines.sample.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JPAMain {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("wings-persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try{

            Member member = entityManager.find(Member.class, 52L);

            entityManager.detach(member);

            // TODO - 해당 부분에서 영속 계층으로 등록되었는데 왜? 인식이 안되나! 확인필요!!
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
