package bong.lines.jpashoping.step3;

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
            member.setTeam(team);

            entityManager.persist(member);

            // 만약 영속성 컨텍스트가 아닌 db에서 쿼리로 조회해오고 싶다면,
            entityManager.flush(); // db에 모든 값 반영 - commit 전에 반영 가능
            entityManager.clear(); // 영속성 컨텍스트 초기화

            Member member1 = entityManager.find(Member.class, member.getId());

            Team team1 = member.getTeam();

            List<Member> members = member1.getTeam().getMembers();;
            
            for(Member m : members){
                System.out.println("m.getUsername() = " + m.getUsername());
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
