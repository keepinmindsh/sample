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
