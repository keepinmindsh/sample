package bong.lines.jpashoping.proxy;

import org.hibernate.Hibernate;

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
            // Proxy 지원 객체
            Member m1 = new Member();
            m1.setUsername("Sleepy1");
            entityManager.persist(m1);

            entityManager.flush();
            entityManager.clear();

            Member refM1 = entityManager.getReference(Member.class, m1.getId()); // Proxy 가 한번 조회가 되면
            System.out.println("findM1.getClass() = " + refM1.getClass());

            // 초기화가 되지 않았기 때문에 false
            System.out.println("refM1 = " + entityManagerFactory.getPersistenceUnitUtil().isLoaded(refM1) );

            // 초기화 되었기 때문에 true
            refM1.getUsername();
            System.out.println("refM1 = " + entityManagerFactory.getPersistenceUnitUtil().isLoaded(refM1) );

            // PROXY 강제 초기화 방법
            // jpa 표준에는 강제 초기화 방법은 없음
            Hibernate.initialize(refM1);


            // 영속성 컨텍스트의 도움을 받을 수 없는 준영속 상태일 때, 프록시를 초기화하는 문제 발생
            /*
            Member m1 = new Member();
            m1.setUsername("Sleepy1");
            entityManager.persist(m1);

            entityManager.flush();
            entityManager.clear();

            Member refM1 = entityManager.getReference(Member.class, m1.getId()); // Proxy 가 한번 조회가 되면
            System.out.println("findM1.getClass() = " + refM1.getClass());

            entityManager.detach(refM1); // 준영속 상태로 변경된 상태에서는
            entityManager.close(); // 영속성을 다는 경우에도
            entityManager.clear(); // 영속성을 Clear 하는 경우에도

            refM1.getUsername(); //  영속성 컨텍스트와 분리되기 때문에 세션에서 호출할 수 없다. 영속성 컨텍스트가 없다는 것임.
            System.out.println("refM1.getUsername() = " + refM1.getUsername());
            */

            // 동일한 Reference에 대해서 비교시 true가 되어야하므로 동일한 proxy객체가 공유된다.
            /*
            Member m1 = new Member();
            m1.setUsername("Sleepy1");
            entityManager.persist(m1);

            entityManager.flush();
            entityManager.clear();

            Member refM1 = entityManager.getReference(Member.class, m1.getId()); // Proxy 가 한번 조회가 되면
            System.out.println("findM1.getClass() = " + refM1.getClass());

            Member findMember = entityManager.find(Member.class, m1.getId()); // em.find에서도 프록시 객체로 조회됨.
            System.out.println("findM1.getClass() = " + findMember.getClass());
             */

            // 영속성 컨텍스트에 이미 로딩되어 있다면 getReference 사용하더라도 실제 Entity 반환
            // - 이미 멤버를 영속성 컨텍스트에 올려두었기 때문에 굳이 재호출 필요 없음
            // - JPA에서는 A == A는 항상 TRUE 여야함, 따라서 findM1 == referenceM1 반드시  true를 반환해야함.
            // - JPA의 기본 개념임.
            /*
            Member m1 = new Member();
            m1.setUsername("Sleepy1");
            entityManager.persist(m1);

            entityManager.flush();
            entityManager.clear();

            Member findM1 = entityManager.find(Member.class, m1.getId());
            System.out.println("findM1.getClass() = " + findM1.getClass());

            Member referenceM1 = entityManager.getReference(Member.class, m1.getId());
            System.out.println("findM1.getClass() = " + referenceM1.getClass());

             */
            

            // Proxy 객체와의 타입 체크시
 /*
            Member m1 = new Member();
            m1.setUsername("Sleepy1");
            entityManager.persist(m1);

            Member m2 = new Member();
            m2.setUsername("Sleepy1");
            entityManager.persist(m2);

            entityManager.flush();
            entityManager.clear();

            Member findM1 = entityManager.find(Member.class, m1.getId());
            Member findM2 = entityManager.find(Member.class, m2.getId());
            Member proxyM2 = entityManager.getReference(Member.class, m2.getId());

            System.out.println("proxyM2 == findM2 = " + (proxyM2 == findM2));
            System.out.println("proxyM2 == findM2 = " + (proxyM2 instanceof Member));
            System.out.println("proxyM2 == findM2 = " + (findM2 instanceof Member));*/

            // 기본 Proxy 활용
            /*
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

             */
            entityTransaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
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
