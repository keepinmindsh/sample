package bong.lines.sample.opration;

import bong.lines.comm.TransactionCommand;
import bong.lines.sample.entity.MemberBasic;

import javax.persistence.EntityManager;

public class BasicSample implements TransactionCommand {
    @Override
    public void procedure(EntityManager entityManager) {

        MemberBasic memberBasic = new MemberBasic();

        memberBasic.setUsername("Seung Hwa");

        entityManager.persist(memberBasic);

        entityManager.detach(memberBasic);

        MemberBasic memberBasicSelect = entityManager.merge(memberBasic);

        memberBasicSelect.setUsername("Seung Hwa!");
    }
}
