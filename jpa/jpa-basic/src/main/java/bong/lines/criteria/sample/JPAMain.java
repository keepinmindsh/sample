package bong.lines.criteria.sample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JPAMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        try{
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

            CriteriaQuery<Member> criteriaQuery = criteriaBuilder.createQuery(Member.class);

            Root<Member> memberRoot = criteriaQuery.from(Member.class);

            criteriaQuery.select(memberRoot);

            String userName = "test";
            if(userName != null){  // 동적으로 사용하는 쿼리
                criteriaQuery.where(criteriaBuilder.equal(memberRoot.get("username"),"kim"));
            }

            entityManager.createQuery(criteriaQuery);

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
