package bong.lines.jpashoping.manytomany;

import bong.lines.jpashoping.step3.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JPAMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        try{

            // Team을 저장하는 방법
            Team team = new Team();
            team.setName("TEAM A");
            entityManager.persist(team); // 영속 상태가 되면 무조건 pk 값은 생성됨.

            Member member = new Member();
            member.setUsername("Lines Bong");
            member.changeTeam(team);

            entityManager.persist(member);

            // 양방향 관계의 Mapping 시 영속성 컨텍스트의 이해를 위하여
            // 만약 영속성 컨텍스트가 아닌 db에서 쿼리로 조회해오고 싶다면,
            // entityManager.flush(); // db에 모든 값 반영 - commit 전에 반영 가능
            // entityManager.clear(); // 영속성 컨텍스트 초기화

            Team findTeam = entityManager.find(Team.class, 1L);

            List<Member> teamMembers = findTeam.getMembers();

            for (Member teamMember : teamMembers) {
                System.out.println("teamMember.getUsername() = " + teamMember.getUsername());
            }

            entityTransaction.commit();
        }catch (Exception exception){
            entityTransaction.rollback();
        }finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
