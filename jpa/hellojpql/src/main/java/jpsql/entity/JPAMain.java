package jpsql.entity;

import javax.persistence.*;
import java.util.List;

public class JPAMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        try{

            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            entityManager.persist(member);

            //sampleQuery0(entityManager);
            //sampleQuery1(entityManager);
            //sampleQuery2(entityManager);
            sampleQuery3(entityManager);

            entityTransaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
            entityTransaction.rollback();
        }finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }

    private static void sampleQuery0(EntityManager entityManager) {
        // 반환 타입이 명확한 경우
        TypedQuery<Member> memberTypedQuery1 = entityManager.createQuery("select m from Member m", Member.class);

        // 반환 타입이 문자열/숫자 등이 섞여 명확하지 않은 경우
        Query query = entityManager.createQuery("select m.username from Member m");

    }

    private static void sampleQuery1(EntityManager entityManager) {
        TypedQuery<Member> memberTypedQuery1 = entityManager.createQuery("select m from Member m", Member.class);

        List<Member> memberList = memberTypedQuery1.getResultList();

        for (Member memberItem : memberList){
            System.out.println("memberItem.getUsername() = " + memberItem.getUsername());
        }
    }

    private static void sampleQuery2(EntityManager entityManager) {
        // 반환 타입이 명확한 경우
        TypedQuery<Member> memberTypedQuery1 = entityManager.createQuery("select m from Member m", Member.class);

        Member singleResult = memberTypedQuery1.getSingleResult();

        System.out.println("singleResult.get(0) = " + singleResult);

    }

    private static void sampleQuery3(EntityManager entityManager) {
        Member singleResult  = entityManager
                .createQuery("select m from Member m where m.username = :username", Member.class)
                .setParameter("username", "member1")
                .getSingleResult();

        System.out.println("singleResult = " + singleResult);
    }
}
