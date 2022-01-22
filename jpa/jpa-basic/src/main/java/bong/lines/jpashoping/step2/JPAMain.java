package bong.lines.jpashoping.step2;

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
            team.setName("TEAM A");
            entityManager.persist(team);

            Member member = new Member();
            member.setUsername("Lines Bong");
            member.setTeam(team);

            entityManager.persist(member);

            // 만약 영속성 컨텍스트가 아닌 db에서 쿼리로 조회해오고 싶다면,
            entityManager.flush(); // db에 모든 값 반영 - commit 전에 반영 가능
            entityManager.clear(); // 영속성 컨텍스트 초기화

            Member member1 = entityManager.find(Member.class, member.getId());

            Team team1 = member.getTeam();

            System.out.println("team1.getTeamId() = " + team1.getTeamId());
            System.out.println("team1.getName() = " + team1.getName());

            // TODO - Team을 업데이트 할 수 있는 방법 - 문서 정리 필요
            Team newTeam = entityManager.find(Team.class, 1L);
            member1.setTeam(newTeam);

            entityTransaction.commit();
        }catch (Exception exception){
            entityTransaction.rollback();
        }finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
