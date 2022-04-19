package bong.lines.sample;

import bong.lines.sample.entity.MemberBasic;
import bong.lines.sample.entity.TeamBasic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SampleJPA {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("wings-persistence");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        try {

            TeamBasic teamBasic = new TeamBasic();
            teamBasic.setId(10L);
            teamBasic.setTeamName("Hong");

            MemberBasic memberBasic = new MemberBasic();
            memberBasic.setId(100L);
            memberBasic.setUsername("Hong");
            memberBasic.setTeamBasic(teamBasic);

            entityManager.persist(memberBasic);

            entityManager.flush();
            entityManager.clear();

            MemberBasic findMemberBasic = entityManager.find(MemberBasic.class, 1L);

            System.out.println("findMemberBasic.getTeamBasic().getTeamName() = " + findMemberBasic.getTeamBasic().getTeamName());
            entityTransaction.commit();
        } catch (Exception exception) {

            exception.printStackTrace();
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}