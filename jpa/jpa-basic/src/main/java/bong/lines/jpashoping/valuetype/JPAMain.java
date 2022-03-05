package bong.lines.jpashoping.valuetype;


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

            Address address = new Address("city", "address", "zipcode");

            Member member1 = new Member();
            member1.setName("Hello World1!");
            member1.setHomeAddress(address);
            member1.setWorkAddress(address);
            entityManager.persist(member1);

            Member member2 = new Member();
            member2.setName("Hello World2!");
            member2.setHomeAddress(address);
            member2.setWorkAddress(address);
            entityManager.persist(member2);

            member2.getHomeAddress().setCity("Change");

            entityManager.persist(member2);

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
