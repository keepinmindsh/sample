package bong.lines.jpashoping.valuetypecollection;



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

            Member member = new Member();

            member.setName("Member1");
            member.setHomeAddress(new Address("city1", "Street", "zip code"));

            member.getFavoriteFood().add("치킨");
            member.getFavoriteFood().add("족발");
            member.getFavoriteFood().add("피자");

            member.getAddressHistory().add(new Address("city2", "Street 1", "zip code 1"));
            member.getAddressHistory().add(new Address("city3", "Street 2", "zip code 2"));

            entityManager.persist(member);


            entityManager.flush();
            entityManager.clear();

            Member findMember = entityManager.find(Member.class, member.getId());

            List<Address> addressList = findMember.getAddressHistory();
            for (Address address: addressList){
                System.out.println("address.getCity() = " + address.getCity());
            }

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
