package bong.lines;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class HelloWorldJPA {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        try{

            // TODO 1차 캐시
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("Hello");
//            entityManager.persist(member);

            //Member member1 = entityManager.find(Member.class, 101L);
            //Member member2 = entityManager.find(Member.class, 101L);

            // TODO - 비영속, 영속 상태
            // 비영속
            //Member member = new Member();
            //member.setId(100L);
            //member.setName("Bong JPA");

            // 영속 상태
            // persist 시점에는 실제로 데이터가 저장되는 시점이 아님.
            //entityManager.persist(member);

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
            //Member findMember = entityManager.find(Member.class, 1L);
            //findMember.setName("Good!");

            // TODO QUERY - JPQL 방언에 맞춰서 Paging 등의 쿼리 적용이 가능함.
//            List<Member> memberList = entityManager.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10)
//                    .getResultList();
//            memberList.forEach(
//                    item -> {
//                        System.out.println("name : " + item.getName());
//                    }
//            );

            entityTransaction.commit();
        }catch (Exception exception){
            entityTransaction.rollback();
        }finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
