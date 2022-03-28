package bong.lines.sample.opration;

import bong.lines.comm.TransactionCommand;
import bong.lines.sample.entity.MemberIdentity;

import javax.persistence.EntityManager;

public class IdentitySample implements TransactionCommand {
    @Override
    public void procedure(EntityManager entityManager) {
        MemberIdentity memberIdentity = new MemberIdentity();

        memberIdentity.setUsername("Seung Hwa");

        entityManager.persist(memberIdentity);

        System.out.println("memberIdentity.getId() = " + memberIdentity.getId());
    }
}
