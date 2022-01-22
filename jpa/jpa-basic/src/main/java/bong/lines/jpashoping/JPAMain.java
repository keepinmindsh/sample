package bong.lines.jpashoping;

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

            Team team = new Team();
            team.setName("Bong Team");
            entityManager.persist(team);

            Member member = new Member();
            member.setUsername("Member 1");
            member.setTeamId(team.getTeamId());
            entityManager.persist(member);

            Member findMember = entityManager.find(Member.class, member.getId());

            Long findTeamId = findMember.getTeamId();
            Team findTeam = entityManager.find(Team.class, findTeamId);

            System.out.println("findTeam.getTeamId() = " + findTeam.getTeamId());
            System.out.println("findTeam.getName() = " + findTeam.getName());

            entityTransaction.commit();
        }catch (Exception exception){
            entityTransaction.rollback();
        }finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
