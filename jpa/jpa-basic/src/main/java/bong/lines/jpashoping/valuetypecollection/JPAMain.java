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
            //member.setHomeAddress(new Address("city1", "Street", "zip code"));

            member.getFavoriteFood().add("치킨");
            member.getFavoriteFood().add("족발");
            member.getFavoriteFood().add("피자");

            member.getAddressHistory().add(new AddressEntity("city2", "Street 1", "zip code 1"));
            member.getAddressHistory().add(new AddressEntity("city3", "Street 2", "zip code 2"));

            entityManager.persist(member);


            entityManager.flush();
            entityManager.clear();

            Member findMember = entityManager.find(Member.class, member.getId());

            //List<AddressEntity> addressList = findMember.getAddressHistory();
            //for (AddressEntity address: addressList){
            //    System.out.println("address.getCity() = " + address.getCity());
            //}

            // 값타입은 아래와 같이 변경은 불가함.
            // findMember.getHomeAddress().setCity("newCity");

            // 아래의 코드가 정상적인 방식
            //Address address = findMember.getHomeAddress();
            //findMember.setHomeAddress(new Address("new City", address.getStreet(), address.getZipcode()));

            // 치킨 -> 한식
            //findMember.getFavoriteFood().remove("치킨");
            //findMember.getFavoriteFood().add("한식");

            // 주소 변경 처리
            // 해당 부분에서 아래의 쿼리의 동작이 관련 member_id를 모두 지우고 다시 아래 값을 입력함.
            // @OrderColumn을 활용하면 배열이 인덱스가 컬럼을 사용하게 되겠지만, 기본적으로는 복잡해질 경우에는 사용하지 않는 방안을 추천함.
            //findMember.getAddressHistory().remove(new Address("city2", "Street 1", "zip code 1"));
            //findMember.getAddressHistory().add(new Address("newCity1", "Street 1", "zip code 1"));

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
