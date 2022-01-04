package bong.lines;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HelloWorldJPA {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        try{
            // TODO 저장 클래스 분리
            //Member member = new Member();
            //member.setId(2L);
            //member.setName("Hello");
            //entityManager.persist(member);

            // TODO 조회 클래스 분리
            //Member findMember = entityManager.find(Member.class, 1L);
            //System.out.println("Id :" + findMember.getId() + ", Name : " + findMember.getName());

            // TODO 삭제
            //Member findMember = entityManager.find(Member.class, 1L);
            //entityManager.remove(findMember);

            // TODO 수정 - JPA를 통해서 객체를 반환하면 해당 객체는 JPA에서 관리하여 변경사항을 Transaction Commit시 반영한다.
            Member findMember = entityManager.find(Member.class, 1L);
            findMember.setName("Good!");

            entityTransaction.commit();
        }catch (Exception exception){
            entityTransaction.rollback();
        }finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
