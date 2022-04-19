package bong.lines.jpql.sample;

import javax.persistence.*;
import java.util.List;

public class JPAMain {
    // TODO 샘플 코드 작성을 위한 코드 고도화 필요
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        try{

            Member member = new Member();

            member.setUserName("Seung Hwa");

            entityManager.persist(member);

            entityManager.flush();
            entityManager.clear();

            List<Member> result = entityManager.createQuery("select m.userName, m.age from Member m").getResultList();

            TypedQuery<Member> memberTypedQuery = entityManager.createQuery("SELECT m from Member  m", Member.class);
            List<Member> memberList = memberTypedQuery.getResultList();
            Member findMember = memberList.get(0);
            System.out.println("findMember.getUserName() = " + findMember.getUserName());
            System.out.println("findMember.getAge() = " + findMember.getAge());

            Query query = entityManager.createQuery("SELECT m.userName, m.age from Member m");

            List resultList = query.getResultList();
            Object o = resultList.get(0);
            Object[] resultObj = (Object[])o;
            System.out.println("resultObj[0] = " + resultObj[0]);
            System.out.println("resultObj[0] = " + resultObj[1]);

            List<Object[]> resultListWithCasting = query.getResultList();
            Object[] resultWithCasting = resultListWithCasting.get(0);
            System.out.println("resultObj[0] = " + resultWithCasting[0]);
            System.out.println("resultObj[0] = " + resultWithCasting[1]);

            List<MemberDTO> resultList1 = entityManager.createQuery("SELECT new bong.lines.jpql.sample.MemberDTO(m.userName, m.age) from Member m", MemberDTO.class).getResultList();

            MemberDTO selectedMemberDTO = resultList1.get(0);
            System.out.println("selectedMemberDTO.getUserName() = " + selectedMemberDTO.getUserName());
            System.out.println("selectedMemberDTO.getAge() = " + selectedMemberDTO.getAge());

            entityTransaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
            entityTransaction.rollback();
        }finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
