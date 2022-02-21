package bong.lines.jpashoping.proxy;

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
            member.setUsername("Id");

            entityManager.persist(member);

            entityManager.flush();
            entityManager.clear();

            //Member findMember = entityManager.find(Member.class, 1L);
            //printMemberAndTeam(findMember);

            Member findRefMember = entityManager.getReference(Member.class, member.getId());
            System.out.println("findRefMember.getClass() = " + findRefMember.getClass());
            System.out.println("findRefMember.getUsername() = " + findRefMember.getUsername());

            entityTransaction.commit();
        }catch (Exception exception){
            entityTransaction.rollback();
        }finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }

    // 업무 로직에 따라서 Team을 가져와야하는 경우도 있고, Member만 가져와야하는 경우가 있을 때,
    // 만약 Member만 사용하고 Team을 사용할 일이 없는 경우, Team 객체는 불필요한 리소스 낭비가 잃어남.
    private static void printMemberAndTeam(Member member) {

        String userName = member.getUsername();
        System.out.println("userName = " + userName);

        Team team = member.getTeam();
        System.out.println("team = " + team);
    }
}
