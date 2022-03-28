package bong.lines.sample;

import bong.lines.comm.TransactionTemplate;
import bong.lines.sample.entity.Member;

public class JPAMain {
    public static void main(String[] args) {
        new TransactionTemplate(
                (entityManager) -> {

                    Member member = new Member();
                    
                    member.setUsername("Seung Hwa");

                    entityManager.persist(member);
                }
        ).process();
    }
}
